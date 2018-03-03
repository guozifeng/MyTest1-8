package com.guo.offer.testutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 问题解决第三种方式
 * threadlocal方式解决
 * @author Administrator
 *
 */
public class DateFormatTest3 {

    private static String date[] = {"01-Jan-1999", "01-Jan-2000", "01-Jan-2001"};

    public static void main(String[] args) {
        for (int i = 0; i < date.length; i++) {
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str1 = date[temp];
                            Date date = DateUtil.parse(str1, "yyyy-MM-dd");
                            String str2 = DateUtil.format(date, "yyyy-MM-dd");
                            // String str2 = sdf.format(sdf.parse(str1));
                            // System.out.println(Thread.currentThread().getName()
                            // + ", " + str1 + "," + str2);
                            if (!str1.equals(str2)) {
                                throw new RuntimeException(
                                    Thread.currentThread().getName() + ", Expected " + str1 + " but got " + str2);
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("parse failed", e);
                    }
                }
            }).start();
        }
    }
}