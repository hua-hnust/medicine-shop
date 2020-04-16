package com.medicine.shop.util;

import java.security.MessageDigest;

/** MD5加密工具
 * @Author xhua
 * @Date 2020/3/24 10:00
 **/
public class MD5Util {

    public static String encrypt(String context){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(context.getBytes());
            byte[] encryptContent = digest.digest();

            int i;

            for (int offset = 0;offset < encryptContent.length;offset++){
                i = encryptContent[offset];
                if (i<0) {
                    i += 256;
                }
                if (i<16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return stringBuilder.toString();
    }
}
