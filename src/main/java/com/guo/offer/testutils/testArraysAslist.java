package com.guo.offer.testutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testArraysAslist {

	public static void main(String[] args) {

		String[] str = new String[] { "a", "b" };
		List list = Arrays.asList(str);
		//list.add("22");
		str[1] = "22";
		System.out.println(str[0]);
		System.out.println(str[1]);
	}

}
