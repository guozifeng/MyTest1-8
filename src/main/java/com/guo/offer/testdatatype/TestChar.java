package com.guo.offer.testdatatype;

import java.io.IOException;

public class TestChar {

	public static void main(String[] args) throws IOException {

		String chnStr1 = "жа";
		System.out.println("length of two Chinese character: " + chnStr1.getBytes("UTF-8").length);
		String engStr = "e";
		System.out.println("length of two English character: " + engStr.getBytes("UTF-8").length);

		String chnStr = "жа";
		System.out.println("length of one Chinese character in gbk: " + chnStr.getBytes("GBK").length);
		System.out.println("length of one Chinese character in UTF-8: " + chnStr.getBytes("UTF-8").length);
		System.out.println("length of one Chinese character in Unicode: " + chnStr.getBytes("UNICODE").length);

		System.out.println("char:" + Character.SIZE);
		System.out.println("int:" + Integer.SIZE);
		System.out.println("short:" + Short.SIZE);
		System.out.println("long:" + Long.SIZE);
		System.out.println("byte:" + Byte.SIZE);
		System.out.println("float:" + Float.SIZE);
		System.out.println("double:" + Double.SIZE);
	}

}
