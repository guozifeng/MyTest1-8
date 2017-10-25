package com.guo.offer.testSimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		test5();
	}

	public static void test1() {
		Date date = new Date();
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		System.out.println(sdf.format(date));
	}
	
	public static void test5() {
		try {
			System.out.println(DateUtil.parse("10-10-2017"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
		Date date = new Date();// 获取当前时间
		System.out.println("现在时间：" + sdf.format(date));
	}

	public static void test3() {
		Long timeStamp = System.currentTimeMillis(); // 获取当前时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp)))); // 时间戳转换成时间
		System.out.println(sd);
	}

	public static void test4() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		int dom = cal.get(Calendar.DAY_OF_MONTH);
		int doy = cal.get(Calendar.DAY_OF_YEAR);

		System.out.println("当期时间: " + cal.getTime());
		System.out.println("日期: " + day);
		System.out.println("月份: " + month);
		System.out.println("年份: " + year);
		System.out.println("一周的第几天: " + dow); // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
		System.out.println("一月中的第几天: " + dom);
		System.out.println("一年的第几天: " + doy);
	}
}
