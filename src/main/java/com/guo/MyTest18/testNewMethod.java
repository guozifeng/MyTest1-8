package com.guo.MyTest18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class testNewMethod {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car1 [name=" + name + "]";
	}

	public static testNewMethod create(final Supplier<testNewMethod> supplier) {
		return supplier.get();
	}

	public static void collide(final testNewMethod car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final testNewMethod another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
	
	public static void main(String args[]){
		final testNewMethod car = testNewMethod.create( testNewMethod::new );
		car.setName("1");
		final List< testNewMethod > cars = Arrays.asList( car );
		
		cars.forEach( testNewMethod::collide );
		
		cars.forEach( testNewMethod::repair );
		
		final testNewMethod police = testNewMethod.create( testNewMethod::new );
		police.setName("police");
		cars.forEach( police::follow );
	}
}