package com.guo.MyTest18;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		String st = sdf.format(date);
		int i = ca.get(Calendar.DAY_OF_YEAR);
		int a = ca.get(Calendar.DAY_OF_MONTH);
		System.out.println("当前时间是：" + st + ";一年中的" + i + "一个月中的" + a);
		
		String collectDate = "171115";
		System.out.println(new Integer(collectDate.substring(4)));
	}

}
