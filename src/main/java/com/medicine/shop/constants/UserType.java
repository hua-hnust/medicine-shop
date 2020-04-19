package com.medicine.shop.constants;

import lombok.AllArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/22 0:43
 **/
@AllArgsConstructor
public enum UserType implements Enums{

    ADMIN(1,"管理员"),
    GENERAL_USER(2,"普通用户");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
