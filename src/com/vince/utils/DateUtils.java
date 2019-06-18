package com.vince.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuxingxing
 * @date 2019-06-18 19:56
 */
public class DateUtils {
    public static String toDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
