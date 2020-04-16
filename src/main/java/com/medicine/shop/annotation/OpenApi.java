package com.medicine.shop.annotation;

import java.lang.annotation.*;

/** 免登陆注解
 * @Author xhua
 * @Date 2020/3/21 23:57
 **/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenApi {
}

