package com.guo.MyTest18;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaTest8 {

	public static void main(String[] args) {

		// ��һ�����������룬�ڶ��������������
		Function<String, Integer> function = (x) -> {
			System.out.print(x + ": ");
			return 2222;
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

		// BiConsumer<T,U> - T,U��Ϊ���룬ִ��ĳ�ֶ�����û�з���ֵ
		BiConsumer<String, Integer> bicon = (x, y) -> {
			System.out.println(x);
			System.out.println(y);
		};
		bicon.accept("guozifeng", 111);

		// Supplier<T> - û���κ����룬����T
		Supplier<String> supp = () -> {
			return "Supplier";
		};
		System.out.println(supp.get());

		// BinaryOperator<T> -����T��Ϊ���룬����һ��T��Ϊ��������ڡ�reduce������������
		BinaryOperator<String> bina = (x, y) -> {
			System.out.println(x + "====" + y);
			return y;
		};
		System.out.println("+++" + bina.apply("hello1 ", "world5"));
	}

}
