package com.guo.offer.testthread.threadstatus;

//�ļ��� : DisplayMessage.java
//ͨ��ʵ�� Runnable �ӿڴ����߳�
public class DisplayMessage implements Runnable {
	private String message;

	public DisplayMessage(String message) {
		this.message = message;
	}

	@Override
    public void run() {
		while (true) {
			System.out.println(message);
		}
	}
}