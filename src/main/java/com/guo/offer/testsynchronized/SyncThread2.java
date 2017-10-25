package com.guo.offer.testsynchronized;

/**
 * 同步线程
 */
class SyncThread2 implements Runnable {
	private static int count;

	public SyncThread2() {
		count = 0;
	}

	public static void method() {
		synchronized (SyncThread.class) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void run() {
		method();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyncThread2 syncThread1 = new SyncThread2();
		SyncThread2 syncThread2 = new SyncThread2();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
	}

}
