package com.guo.offer.outofmemory;

public class OOMTest {

	public void stackOverFlowMethod() {
		stackOverFlowMethod();
	}

	public static void main(String... args) {
		OOMTest oom = new OOMTest();
		oom.stackOverFlowMethod();
	}
}