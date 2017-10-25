package com.guo.offer.testregex;

/**
 * http://www.cnblogs.com/lzq198754/p/5780340.html
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches1 {
	private static final String REGEX = "\\bcat\\b";
	private static final String INPUT = "cat cat cat cattie cat";

	public static void main(String args[]) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT); // 获取 matcher 对象
		int count = 0;
		System.out.println(m.groupCount());
		while (m.find()) {
			count++;
			System.out.println(m.group(0) + " Match number " + count);
			System.out.println(m.group(0) + " start(): " + m.start());
			System.out.println(m.group(0) + " end(): " + m.end());

		}
	}
}