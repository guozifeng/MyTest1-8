package com.guo.offer.testsynchronized;

import java.util.HashMap;
import java.util.Map;

public class TestJoin implements Runnable {

	private static Integer count = 0;

	private static Map<String, String> map = new HashMap<String, String>();

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			synchronized (map) {
				map.put(getCount(), getCount());
			}
		}

	}

	private String getCount() {
		count++;
		System.out.println(Thread.currentThread().getName() + " : " + count);
		return count.toString();

	}

	public static void test1(){
		TestJoin a = new TestJoin();
		Thread thread1 = new Thread(a, "SyncThread1");
		Thread thread2 = new Thread(a, "SyncThread2");
		thread1.start();
		thread2.start();
		System.out.println("map.size()= "+map.size());
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("map.size()= "+map.size());
	}
	
	public static void test2(){
		TestJoin a = new TestJoin();
		TestJoin a1 = new TestJoin();
		Thread thread1 = new Thread(a, "SyncThread1");
		Thread thread2 = new Thread(a1, "SyncThread2");
		thread1.start();
		thread2.start();
		System.out.println("map.size()= "+map.size());
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("map.size()= "+map.size());
	}
	public static void main(String[] args) {
		test2();

	}

}
