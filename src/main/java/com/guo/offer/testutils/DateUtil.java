package com.guo.offer.testutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

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

    public static String formatDate(Date date, String format) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            result = sdf.format(date);
        }
        return result;
    }

    public static Date formatString(String str, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    @Test
    public void test3() {
        Date date = null;
        try {
            date = formatString("2017-11-15 00:00:00", "yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(date);

        System.out.println(new Date());
        String str1 = formatDate(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(str1);

        // 获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        System.out.println(c.getTime());
        String first = formatDate(c.getTime(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("===============first:" + first);

        // 获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = formatDate(ca.getTime(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("===============last:" + last);

        Userr r = new Userr();
        r.setDate(new Date());
        System.out.println(r.getDate());
    }

    @Test
    public void test1() {
        Calendar now = Calendar.getInstance();
        System.out.println("年: " + now.get(Calendar.YEAR));
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1));
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分: " + now.get(Calendar.MINUTE));
        System.out.println("秒: " + now.get(Calendar.SECOND));
        System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
        System.out.println(now.getTime());

        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        String str = "2012-1-13 17:26:33"; // 要跟上面sdf定义的格式一样
        Date today = null;
        try {
            today = sdf.parse(str);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("字符串转成日期：" + today);
    }

    @Test
    public void getWeeksByChooseDay() {
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String st = sdf.format(date);

        int i = ca.get(Calendar.DAY_OF_YEAR);
        int a = ca.get(Calendar.DAY_OF_MONTH);
        System.out.println("当前时间是：" + st + ";一年中的" + i + "一个月中的" + a);
    }

    public static String getCollectDate(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);

        int days = ca.get(Calendar.DAY_OF_MONTH);
        int last = ca.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (days <= 15) {
            days = 15;
        }
        if (16 <= days && days <= 27) {
            days = 27;
        }
        if (days >= 28) {
            days = last;
        }
        ca.set(Calendar.DAY_OF_MONTH, days);
        String retrun = DateFormatUtils.format(ca.getTime(), "yyMMdd");

        return retrun;
    }

    public static void main(String[] args) throws Exception {
        Date date = null;
        try {
            date = formatString("2017-09-17 00:00:00", "yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(getCollectDate(date));

    }
}