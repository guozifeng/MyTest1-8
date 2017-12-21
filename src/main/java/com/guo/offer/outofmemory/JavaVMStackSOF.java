package com.guo.offer.outofmemory;

/**
 * �����ջ�ͱ��ط���ջ��� -Xss128k
 * -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -XX:+PrintGCDetails
 * @author Nicholas ��hotspot������в����������ջ�ͱ��ط���ջ Ҳ����˵ -Xoss������Ч ջ����ֻ�� 
 * -Xss��������
 *
 * �ڵ��߳�����£�������ջ̫֡�������������̫С�����ڴ��޷������ʱ�򣬶���stackoverflowerror�쳣
 */

public class JavaVMStackSOF {

	private int stacklength = 1;

	public void stackLeak() {
		stacklength++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stackLeak();
	}

	public static void main(String[] args){
		JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();

		try {
			javaVMStackSOF.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack length : " + javaVMStackSOF.stacklength);
			e.printStackTrace();
		}
	}
}
