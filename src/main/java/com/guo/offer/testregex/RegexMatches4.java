package com.guo.offer.testregex;

/**
 * 用法说明：

String replaceAll(String replacement) 
将目标字符串里与既有模式相匹配的子串全部替换为指定的字符串。 
String replaceFirst(String replacement) 
将目标字符串里第一个与既有模式相匹配的子串替换为指定的字符串。

appendReplacement(StringBuffer sb, String replacement) 
将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串
段添加到一个StringBuffer对象里，而appendTail(StringBuffer sb) 
方法则将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里。 
例如，有字符串fatcatfatcatfat,假设既有正则表达式模式为"cat"，
第一次匹配后调用appendReplacement(sb,"dog"),
那么这时StringBuffer sb的内容为fatdog，
也就是fatcat中的cat被替换为dog并且与匹配子串前的内容加到sb里，
而第二次匹配后调用appendReplacement(sb,"dog")，
那么sb的内容就变为fatdogfatdog，如果最后再调用一次appendTail（sb）,
那么sb最终的内容将是fatdogfatdogfat。 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches4 {
	private static String REGEX = "a+b";
	private static String INPUT = "aabfooaabfooabfoob";
	private static String REPLACE = "-111-";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// 获取 matcher 对象
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, REPLACE);
			// System.out.println(sb);
		}
		System.out.println(sb.toString());
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}