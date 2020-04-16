package com.medicine.shop.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/** 时间格式化工具
 * @Author xhua
 * @Date 2020/3/22 1:42
 **/
public class DateTimeUtil {

    public static String formateDateToString(Date date,String pattern){
        if (date == null){
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static LocalDateTime formatStringToLocalDateTime(String time,String pattern){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(time,df);
    }

}
