package com.medicine.shop.dto;

import com.medicine.shop.constants.Errors;

public class BizException extends RuntimeException {

    private int		code;
    private String	msg;

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(int code) {
        super();
        this.code = code;
    }

    public BizException(String msg) {
        super();
        this.code = -1;
        this.msg = msg;
    }


    public BizException(Errors errors) {
        this(errors.getCode(), errors.getMessage());
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
