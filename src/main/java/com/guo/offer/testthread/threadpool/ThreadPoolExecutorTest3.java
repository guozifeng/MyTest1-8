package com.guo.offer.testthread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * http://cuisuqiang.iteye.com/blog/2019372
 * 
 * @author Administrator
 *
 */
public class ThreadPoolExecutorTest3 {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);
		scheduledThreadPool.shutdown();
	}
}