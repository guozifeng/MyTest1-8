package com.guo.offer.testutils;

import java.util.Arrays;

public class testArraysSort {

	public testArraysSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// 数组初始化
		int[] a = { 3, 5, 2, 1, 8, 6, 9, 4, 0 };
		// 排序
		Arrays.sort(a);
		// 输出排序之后的结果
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
