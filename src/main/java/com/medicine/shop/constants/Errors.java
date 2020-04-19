package com.medicine.shop.constants;

import com.medicine.shop.dto.BizException;
import lombok.AllArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/22 0:50
 **/
@AllArgsConstructor
public enum Errors {

    SMS_VERIFY_ERROR(-1, "incorrect verification code"),
    ILLEGAL_PARAMS(400, "illegal arguments"),
    INVALID_TOKEN(401, "invalid token"),
    NOT_ACCEPT(406,"invalid request"),
    SERVER_ERROR(500,"server exception"),
    NOT_FOUND(404,"请求数据不存在"),
    CONTENT_EMPTY(405,"内容为空"),
    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static BizException of(Errors errors){
        return new BizException(errors);
    }

    public static BizException of(String desc){
        return new BizException(-1, desc);
    }

}
