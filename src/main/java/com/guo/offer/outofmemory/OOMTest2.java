package com.guo.offer.outofmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest2 {
	public static void main(String... args) {
		List<String> list = new ArrayList<String>();
		while (true) {
			list.add(UUID.randomUUID().toString().intern());
			System.out.println("���ڴ棺" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
			System.out.println("�����ڴ棺" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
			System.out.println("��ʹ���ڴ棺"
					+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "M");

		}
	}
}