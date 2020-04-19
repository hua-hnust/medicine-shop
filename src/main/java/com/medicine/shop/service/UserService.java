package com.medicine.shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medicine.shop.constants.DataStatus;
import com.medicine.shop.entity.User;
import com.medicine.shop.interceptor.SessionContext;
import com.medicine.shop.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author xhua
 * @Date 2020/3/22 0:27
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, User> {


    @Resource
    private UserMapper userMapper;

    public User currentUser() {
        User query = new User();
        query.setToken(SessionContext.getRemoteSid());
        query.setStatus(DataStatus.VALID.getCode());
        return userMapper.selectOne(new QueryWrapper<>(query).gt("token_expire_time",new Date()));
    }
}
