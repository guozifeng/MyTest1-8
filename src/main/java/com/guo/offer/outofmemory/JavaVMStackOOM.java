package com.guo.offer.outofmemory;

/**
 * VM Args£º-Xss2M  -verbose:gc -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -XX:+PrintGCDetails
 * 
 * @author zzm
 */
public class JavaVMStackOOM {

	private void dontStop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		int i =0;
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			System.out.println(i++);
			thread.start();
		}
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
