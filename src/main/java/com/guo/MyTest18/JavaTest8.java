package com.guo.MyTest18;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaTest8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<String, String> function = (x) -> {
			System.out.print(x + ": ");
			return "Function";
		};
		System.out.println(function.apply("hello world1"));

		// Predicate<T> -T��Ϊ���룬���ص�booleanֵ��Ϊ���
		Predicate<String> pre = (x) -> {
			System.out.print(x);
			return false;
		};
		System.out.println(": " + pre.test("hello World2"));

		// Consumer<T> - T��Ϊ���룬ִ��ĳ�ֶ�����û�з���ֵ
		Consumer<String> con = (x) -> {
			System.out.println(x);
		};
		con.accept("hello world3");

		// Supplier<T> - û���κ����룬����T
		Supplier<String> supp = () -> {
			return "Supplier";
		};
		System.out.println(supp.get());

		// BinaryOperator<T> -����T��Ϊ���룬����һ��T��Ϊ��������ڡ�reduce������������
		BinaryOperator<String> bina = (x, y) -> {
			System.out.print(x + "====" + y);
			return "BinaryOperator";
		};
		System.out.println("+++" + bina.apply("hello1 ", "world5"));
	}

}