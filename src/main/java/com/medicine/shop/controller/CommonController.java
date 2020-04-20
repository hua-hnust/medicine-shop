package com.medicine.shop.controller;

import com.medicine.shop.annotation.OpenApi;
import com.medicine.shop.configurations.UploadConfiguration;
import com.medicine.shop.constants.CommonConstants;
import com.medicine.shop.dto.req.LoginParamsDTO;
import com.medicine.shop.dto.req.RegisterDTO;
import com.medicine.shop.dto.req.UpdatePasswordDTO;
import com.medicine.shop.dto.res.LoginInfoDTO;
import com.medicine.shop.entity.User;
import com.medicine.shop.service.AuthService;
import com.medicine.shop.service.UserService;
import com.medicine.shop.util.Exceptions;
import com.medicine.shop.util.FileUtil;
import com.medicine.shop.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

import static com.medicine.shop.constants.Errors.INVALID_TOKEN;
import static com.medicine.shop.constants.Errors.of;

/**
 * @Author xhua
 * @Date 2020/4/19 17:02
 **/
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Resource
    private UploadConfiguration uploadConfiguration;

    @Resource
    private AuthService authService;

    @Resource
    private UserService userService;

    /**
     *  注册接口
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody RegisterDTO registerDTO){
        return authService.register(registerDTO);
    }

    /**
     *  登录接口
     * @param loginParamsDTO
     * @return
     */
    @PostMapping("/login")
    @OpenApi
    public LoginInfoDTO login(@RequestBody LoginParamsDTO loginParamsDTO){
        return authService.verifyPhoneAndPassword(loginParamsDTO.getPhone(), loginParamsDTO.getPassword());
    }

    /**
     *  退出登录
     * @return
     */
    @PostMapping("/logout")
    public Boolean logout(){
        User currentUser = Optional.ofNullable(userService.currentUser()).orElseThrow(() -> of(INVALID_TOKEN));
        currentUser.setTokenExpireTime(new Date(System.currentTimeMillis() - CommonConstants.TOKEN_EXPIRE_TIME));
        return userService.updateById(currentUser);
    }

    /**
     *  修改密码
     * @param updatePasswordDTO
     * @return
     */
    @PostMapping("update-password")
    public Boolean updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO){
        User currentUser = Optional.ofNullable(userService.currentUser()).orElseThrow(() -> of(INVALID_TOKEN));
        String old = MD5Util.encrypt(updatePasswordDTO.getOldPassword());
        if (!currentUser.getPassword().equals(old)){
            Exceptions.throwss("旧密码错误");
            return false;
        }else {
            currentUser.setPassword(MD5Util.encrypt(updatePasswordDTO.getNewPassword()));
            return userService.updateById(currentUser);
        }
    }

    /**
     *  上传文件
     * @param file
     * @return
     */
    @RequestMapping("upload")
    public String upload(@RequestParam("file")MultipartFile file){

        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameFile(fileName);

        try {
            FileUtil.upload(file.getBytes(),uploadConfiguration.getFilePath(),fileName);
        }catch (Exception e){
            Exceptions.throwss("上传文件失败");
        }

        return "/static/" + fileName;
    }

    /**
     *  检查token是否有效
     * @return
     */
    @RequestMapping("check-token")
    public Boolean checkToken(){
        User user = userService.currentUser();
        return user != null;
    }

}
