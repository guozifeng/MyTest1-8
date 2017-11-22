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
			// �����ǰ����Ϊ��ɣ�����get()���߳̾ͻ�ȴ�
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
