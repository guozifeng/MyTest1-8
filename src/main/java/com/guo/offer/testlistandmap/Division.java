package com.guo.offer.testlistandmap;

public class Division {

	public Division() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		System.out.println(a.length);
		int start = 0;
		int end = a.length - 1;
		int m = 0;
		int k = 4;
		while (start <= end) {
			m = (start + end) / 2;
			if (k < a[m]) {
				end = m - 1;
			}
			if (k > a[m]) {
				start = m + 1;
			}
			if (k == a[m]) {
				break;
			}
		}
		System.out.println(m);
	}

}
