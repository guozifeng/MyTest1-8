package com.guo.offer.testutils;

import java.util.Random;

/**
 * 当多线程同时访问类A的setID和getID方法时，每个线程的getID方法会返回自己setID()时设置的值。
 * 那么ThreadLocal类型的成员变量threadLocalID为什么设置为static的呢？ Java
 * 中每个线程都有与之关联的Thread对象，Thread对象中有一个ThreadLocal.ThreadLocalMap类型的成员变量，
 * 该变量是一个Hash表，
 * 所以每个线程都单独维护这样一个Hash表，当ThreadLocal类型对象调用set方法时，即上面的threadLocalID.set(id)，
 * 这个set方法会使用当前线程维护的Hash表，把自己作为key,
 * id作为value插入到Hash表中。由于每个线程维护的Hash表是独立的，因此在不同的Hash表中，key值即使相同也是没问题的。
 * 如果把threadLocalID声明为非静态，则在类A的每个实例中都会产生一个新对象，这是毫无意义的，只是增加了内存消耗。
 * ThreadLocal.set()的实现：
 * 
 * @author Administrator
 *
 */
public class ThreadLocalTest1 implements Runnable {

	ThreadLocal<Studen> studenThreadLocal = new ThreadLocal<Studen>();

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running...");
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println(currentThreadName + " is set age: " + age);
		Studen studen = getStudent(); // 通过这个方法，为每个线程都独立的new一个student对象，每个线程的的student对象都可以设置不同的值
		studen.setAge(age);
		System.out.println(currentThreadName + " is first get age: " + studen.getAge());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(currentThreadName + " is second get age: " + studen.getAge());

	}

	private Studen getStudent() {
		Studen studen = studenThreadLocal.get();
		if (null == studen) {
			studen = new Studen();
			studenThreadLocal.set(studen);
		}
		return studen;
	}

	public static void main(String[] args) {
		ThreadLocalTest1 t = new ThreadLocalTest1();
		Thread t1 = new Thread(t, "Thread A");
		Thread t2 = new Thread(t, "Thread B");
		t1.start();
		t2.start();
	}

}

class Studen {
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
