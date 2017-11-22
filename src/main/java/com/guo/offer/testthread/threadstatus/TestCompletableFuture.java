package com.guo.offer.testthread.threadstatus;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class TestCompletableFuture {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	private static void test1() {

	}
	@Test
	private static void test() {
		final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> calculate(100));
		System.out.println("0000000000000000");
		try {
			// 如果当前计算为完成，调用get()的线程就会等待
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("exit");
	}

	private static int calculate(int x) {
		int res = 0;
		try {
			Thread.sleep(1000);
			System.out.println("------");
			res = x * x * x;
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return res;
	}
}
