package com.medicine.shop.interceptor;

import com.medicine.shop.dto.BizException;
import com.medicine.shop.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BizException.class)
    public Result globalException(HttpServletResponse response, BizException bizException){
        //业务报错进行统一处理
        return Result.error(bizException.getCode(),bizException.getMessage());
    }

}