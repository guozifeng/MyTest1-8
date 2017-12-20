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

        // ��ȡ��ǰ�µ�һ�죺
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// ����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ��
        System.out.println(c.getTime());
        String first = formatDate(c.getTime(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("===============first:" + first);

        // ��ȡ��ǰ�����һ��
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
        System.out.println("��: " + now.get(Calendar.YEAR));
        System.out.println("��: " + (now.get(Calendar.MONTH) + 1));
        System.out.println("��: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("ʱ: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("��: " + now.get(Calendar.MINUTE));
        System.out.println("��: " + now.get(Calendar.SECOND));
        System.out.println("��ǰʱ���������" + now.getTimeInMillis());
        System.out.println(now.getTime());

        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        System.out.println("��ʽ��������ڣ�" + dateNowStr);

        String str = "2012-1-13 17:26:33"; // Ҫ������sdf����ĸ�ʽһ��
        Date today = null;
        try {
            today = sdf.parse(str);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("�ַ���ת�����ڣ�" + today);
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
        System.out.println("��ǰʱ���ǣ�" + st + ";һ���е�" + i + "һ�����е�" + a);
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