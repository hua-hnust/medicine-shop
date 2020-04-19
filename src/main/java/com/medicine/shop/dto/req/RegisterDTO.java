package com.medicine.shop.dto.req;

import lombok.Data;
import lombok.ToString;

/**
 * @Author xhua
 * @Date 2020/3/26 21:55
 **/
@Data
@ToString
public class RegisterDTO {

    /**
     * 用户名称
     */
    private String name;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 身份证号码
     */
    private String cardId;

    /**
     *  头像
     */
    private String headImage;

}
