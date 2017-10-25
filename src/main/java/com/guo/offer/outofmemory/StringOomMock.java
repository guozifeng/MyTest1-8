package com.guo.offer.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms16m -Xmx16m -XX:PermSize=8M -XX:MaxPermSize=8M -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -XX:+PrintGCDetails
 * @author Administrator
 *
 */
public class StringOomMock {
	static String base = "string";

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String str = base + base;
			base = str;
			list.add(str.intern());
		}
	}
}