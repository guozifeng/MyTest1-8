package com.guo.java8;

public class Java8Tester1 {
	public static void main(String args[]) {
		Vehicle vehicle = new Car();
		vehicle.print();
	}
}

interface Vehicle {
	default void print() {
		System.out.println("����һ����!");
	}

	static void blowHorn() {
		System.out.println("������!!!");
	}
}

interface FourWheeler {
	default void print() {
		System.out.println("����һ�����ֳ�!");
	}
}

class Car implements Vehicle, FourWheeler {
    @Override
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("����һ������!");
	}
}