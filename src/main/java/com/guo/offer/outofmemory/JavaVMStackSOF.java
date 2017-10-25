package com.guo.offer.outofmemory;

/**
 * 虚拟机栈和本地方法栈溢出 -Xss128k
 * -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -XX:+PrintGCDetails
 * @author Nicholas 在hotspot虚拟机中不区分虚拟机栈和本地方法栈 也就是说 -Xoss参数无效 栈容量只由 
 * -Xss参数设置
 *
 * 在单线程情况下，无论是栈帧太大还是虚拟机容量太小，当内存无法分配的时候，都是stackoverflowerror异常
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
