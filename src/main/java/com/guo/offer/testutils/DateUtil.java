package com.guo.offer.testutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();

    public static Date parse(String str, String format) throws Exception {
        SimpleDateFormat sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(format, Locale.US);
            local.set(sdf);
        }
        return sdf.parse(str);
    }

    public static String format(Date date, String format) throws Exception {
        SimpleDateFormat sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(format, Locale.US);
            local.set(sdf);
        }
        return sdf.format(date);
    }    
}