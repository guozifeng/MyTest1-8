package com.guo.offer.mytesteight.foo;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class testAndThen {

	static int[] arr = {1,2,3,4,5,6,7,8,9,10};
	public static void main(String[] args) {
		
		IntConsumer out = System.out::println;
		IntConsumer err = System.err::println;
		Arrays.stream(arr).forEach(out.andThen(err));
		
	}
}
