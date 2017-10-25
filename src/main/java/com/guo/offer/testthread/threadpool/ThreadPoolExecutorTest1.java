package com.guo.offer.testthread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://cuisuqiang.iteye.com/blog/2019372
 * 
 * @author Administrator
 *
 */
public class ThreadPoolExecutorTest1 {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
					try {
						Thread.sleep(index * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		cachedThreadPool.shutdown();
	}
}