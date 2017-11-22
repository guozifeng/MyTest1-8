package com.guo.offer.testthread.threadstatus;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCompletableFuture1 {

	public static void main(String[] args) {
		System.out.println("main thread: " + Thread.currentThread());

		new Thread(TestCompletableFuture1::test1) {
			{
				setName("my-new-thread");
			}
		}.start();
		
		test2();
		
		System.out.println("000000000000000");
	}

	private static void test1() {

		CompletionStage<Void> futurePrice = CompletableFuture.runAsync(() -> {
			sleep(1000);
			System.out.println("test1:1 - runAsync(runnable), job thread: " + Thread.currentThread());
		});

		System.out.println("test1:flag1");

		futurePrice.thenRun(() -> {
			System.out.println("test1:2 - thenRun(runnable)), action thread: " + Thread.currentThread());
		});

		System.out.println("test1:flag2");

		futurePrice.thenRunAsync(() -> {
			System.out.println("test1:3 - thenRunAsync(runnable), action thread: " + Thread.currentThread());
		});

	}

	private static void test2() {

		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionStage<Void> futurePrice = CompletableFuture.runAsync(() -> {
			sleep(1000);
			System.out.println("test2:1 - runAsync(runnable, executor), job thread: " + Thread.currentThread());
		}, executorService);

		System.out.println("test2:flag1");

		futurePrice.thenRunAsync(() -> {
			System.out.println("test2:2 - thenRunAsync(runnable), action thread: " + Thread.currentThread());
		});

		System.out.println("test2:flag2");

		futurePrice.thenRun(() -> {
			System.out.println("test2:3 - thenRun(runnable), action thread: " + Thread.currentThread());
		});

		futurePrice.thenRunAsync(() -> {
			System.out.println("test2:4 - thenRunAsync(runnable, executor), action thread: " + Thread.currentThread());
		}, executorService);

		executorService.shutdown();
	}

	private static void sleep(long time) {
		// if(true) return;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
}