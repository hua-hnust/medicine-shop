package com.medicine.shop.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicine.shop.annotation.OpenApi;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author xhua
 * @Date 2020/3/22 12:29
 **/
public abstract class AbstractInterceptor implements HandlerInterceptor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /** 鉴权方法，由子类实现 **/
    protected abstract boolean doCheck(HttpServletRequest request, HttpServletResponse response) throws Exception;


    /**
     *  免登录
     * @param handler
     * @return
     */
    protected Boolean isOpenApi(Object handler){
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            if (method.getAnnotation(OpenApi.class) != null){
                return true;
            }else if (method.getDeclaringClass().getAnnotation(OpenApi.class) != null){
                return true;
            }
        }
        return false;
    }

    /**
     *  验证token是否有效
     * @return
     */
    protected boolean verifyToken(){
        return false;
    }

}
