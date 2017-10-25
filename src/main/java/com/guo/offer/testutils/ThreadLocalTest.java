package com.guo.offer.testutils;

public class ThreadLocalTest {

	static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public static class ThreadA extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				threadLocal.set("ThreadA-" + i);
				System.out.println("ThreadA:" + threadLocal.get());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static class ThreadB extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				threadLocal.set("ThreadB-" + i);
				System.out.println("ThreadB:" + threadLocal.get());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		ThreadA a = new ThreadA();

		ThreadB b = new ThreadB();
		a.start();
		b.start();
	}

}