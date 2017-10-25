package com.guo.offer.testdatatype;

public class aa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = new StringBuilder("¼ÆËã»ú").append("Èí¼ş").toString();
		System.out.println(string1 == string1.intern());

		String string2 = new StringBuilder("ja").append("va").toString();
		System.out.println(string2 == string2.intern());
	}

}
