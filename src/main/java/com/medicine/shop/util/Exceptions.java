package com.medicine.shop.util;

import com.medicine.shop.constants.Errors;
import com.medicine.shop.dto.BizException;

public class Exceptions {

    public static void throwss(int code) {
        Exceptions.throwss(code, null);
    }

    public static void throwss(String msg) {
        Exceptions.throwss(-1, msg);
    }

    public static void throwss(Errors enums) {
        Exceptions.throwss(enums.getCode(), enums.getMessage());
    }

    public static void throwss(int code, String msg) {
        throw new BizException(code, msg);
    }
}

