package com.guo.MyTest18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Car1 {
	@Override
	public String toString() {
		return "Car1 [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public static Car1 create(final Supplier<Car1> supplier) {
		return supplier.get();
	}

	public static void collide(final Car1 car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car1 another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
	
	public static void main(String args[]){
		final Car1 car = Car1.create( Car1::new );
		final List< Car1 > cars = Arrays.asList( car );
		
		cars.forEach( Car1::collide );
		
		cars.forEach( Car1::repair );
		
		final Car1 police = Car1.create( Car1::new );
		cars.forEach( police::follow );
	}
}