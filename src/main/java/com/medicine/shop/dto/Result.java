package com.medicine.shop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.medicine.shop.constants.Errors;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**  统一结果集
 * @Author xhua
 * @Date 2020/3/22 0:46
 **/
@Data
@Builder
public class Result implements Serializable {

    private int code;
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static  Result success(Object data){
        return Result.builder().code(0).msg("ok").data(data).build();
    }

    public static  Result success() {
        return Result.builder().code(0).msg("ok").data(null).build();
    }

    public static  Result error(Errors error) {
        return Result.builder().code(error.getCode()).msg(error.getMessage()).data(null).build();
    }

    public static  Result error(int code, String message) {
        return Result.builder().code(code).msg(message).data(null).build();
    }

    public static  Result error(String message) {
        return Result.builder().code(-1).msg(message).data(null).build();
    }

    public static  Result build(int code, String message, Object data) {
        return Result.builder().code(code).msg(message).data(data).build();
    }

}
