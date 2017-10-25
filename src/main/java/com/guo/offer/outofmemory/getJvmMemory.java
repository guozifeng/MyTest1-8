package com.guo.offer.outofmemory;

public class getJvmMemory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long maxMem = Runtime.getRuntime().maxMemory() / 1024 / 1024;
		long freeMem = Runtime.getRuntime().freeMemory() / 1024 / 1024;
		long totalMemory = Runtime.getRuntime().totalMemory()/1048576;
		System.out.println(maxMem);
		System.out.println(freeMem);
		System.out.println(totalMemory);
	}

}
