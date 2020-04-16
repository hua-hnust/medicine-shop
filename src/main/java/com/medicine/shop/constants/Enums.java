package com.medicine.shop.constants;

import java.lang.reflect.Method;

public interface Enums {

    int getCode();
    String getDesc();

    static <T extends Enums> T valueOf(int code, Class<T> enumType) {
        try {
            Method method = enumType.getMethod("values");
            T[] ts = (T[]) method.invoke(enumType);
//            System.out.println(Arrays.toString(ts));
            for (T t : ts) {
                if (t.getCode() == code) {
                    return t;
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return null;
    }

    static <T extends Enums> boolean isValid(int code, Class<T> enumType) {
        T result = Enums.valueOf(code, enumType);
        return result != null;
    }

    static <T extends Enum> T valueOf(String name, Class<T> enumType) {
        try {
            Method method = enumType.getMethod("valueOf", String.class);
            return (T) method.invoke(enumType, name);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return null;
    }
}