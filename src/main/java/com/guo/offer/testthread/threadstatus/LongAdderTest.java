package com.guo.offer.testthread.threadstatus;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongAdder a = new LongAdder();
		a.add(1);a.add(1);a.add(1);a.add(1);
		
		AtomicLong count = new AtomicLong();
		count.addAndGet(1);
		
		System.out.println(a);
		System.out.println(count);
	}

}
