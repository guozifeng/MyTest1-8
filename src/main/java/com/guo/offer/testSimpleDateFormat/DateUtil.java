package com.guo.offer.testSimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();

	public static Date parse(String str) throws Exception {
		SimpleDateFormat sdf = local.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
			local.set(sdf);
		}
		return sdf.parse(str);
	}

	public static String format(Date date) throws Exception {
		SimpleDateFormat sdf = local.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
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

	public static void main(String[] args) throws Exception {
		Date date = formatString("1993/10/12", "yyyy/MM/dd");
		String str = formatDate(date, "yyyy-MM-dd");
		System.out.println(str);
	}
}