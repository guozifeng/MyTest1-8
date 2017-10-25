package com.guo.offer.commons;

import org.apache.commons.lang3.StringUtils;

public class testUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "";
		String str2 = "  ";
		String str3 = null;

		System.out.println(StringUtils.isEmpty(str1)); // true
		System.out.println(StringUtils.isEmpty(str2)); // false
		System.out.println(StringUtils.isEmpty(str3)); // true

		System.out.println(StringUtils.isBlank(str1)); // true
		System.out.println(StringUtils.isBlank(str2)); // true
		System.out.println(StringUtils.isBlank(str3)); // true

		System.out.println(StringUtils.trimToEmpty(" abc ")); // abc
		System.out.println(StringUtils.trimToEmpty(null)); // ¿Õ×Ö·û´®

		System.out.println(StringUtils.indexOf(null, "abc")); // -1
		System.out.println(StringUtils.indexOf("abcd", "abc")); // 0

	}

}
