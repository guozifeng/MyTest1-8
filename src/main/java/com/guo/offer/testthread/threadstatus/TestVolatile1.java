package com.guo.offer.testthread.threadstatus;

public class TestVolatile1 implements Runnable {
	// private volatile boolean active;

	private volatile boolean active;

	public void run() {
		active = true;
		while (active) // 第一行
		{
			// System.out.println("111111111111111");
		}
	}

	public void stop() {
		active = false; // 第二行
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestVolatile1 m = new TestVolatile1();
		Thread t = new Thread(m);
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.stop();
	}
}