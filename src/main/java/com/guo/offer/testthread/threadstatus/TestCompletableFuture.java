package com.guo.offer.testthread.threadstatus;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class TestCompletableFuture {

	public static void main(String[] args) throws Exception {
		test5();
	}

	private static void test5() {
		
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> calculate(10));
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> divi(50));
		CompletableFuture<Void> cf = future1.thenCombine(future2, (x, y) -> (x + y)).thenAccept(System.out::println);
		try {
			cf.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("exit");
	}

	private static void test4() {
		final int num = 100;
		final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calculate(num))
				.thenCompose((i) -> CompletableFuture.supplyAsync(() -> divi(i)))
				.thenApply((str) -> num + "的平方除以2: " + str).thenAccept(System.out::println);
		try {
			future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("exit");
	}

	private static void test3() {
		final int num = 100;
		final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calculate(num)).thenApply(x -> {
			System.out.println("0000---" + x);
			return Integer.toString(x);

		}).thenApply((str) -> num + "的平方: " + str).thenAccept(System.out::println);
		try {
			future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("exit");
	}

	private static void test2() {
		final CompletableFuture<Integer> future = new CompletableFuture<>();
		new Thread(new TaskRun(future)).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		future.complete(10);
	}

	private static void test1() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(10000);
					System.out.println("=============");

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}));

		System.out.println("=======22======");
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
			res = x * x;
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return res;
	}

	private static int divi(int x) {
		return x / 2;
	}
}
