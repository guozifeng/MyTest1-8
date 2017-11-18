package com.guo.MyTest18;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaTest8 {

	public static void main(String[] args) {

		// 第一个参数是输入，第二个参数是输出。
		Function<String, Integer> function = (x) -> {
			System.out.print(x + ": ");
			return 2222;
		};
		System.out.println(function.apply("hello world1"));

		// Predicate<T> -T作为输入，返回的boolean值作为输出
		Predicate<String> pre = (x) -> {
			System.out.print(x);
			return false;
		};
		System.out.println(": " + pre.test("hello World2"));

		// Consumer<T> - T作为输入，执行某种动作但没有返回值
		Consumer<String> con = (x) -> {
			System.out.println(x);
		};
		con.accept("hello world3");

		// BiConsumer<T,U> - T,U作为输入，执行某种动作但没有返回值
		BiConsumer<String, Integer> bicon = (x, y) -> {
			System.out.println(x);
			System.out.println(y);
		};
		bicon.accept("guozifeng", 111);

		// Supplier<T> - 没有任何输入，返回T
		Supplier<String> supp = () -> {
			return "Supplier";
		};
		System.out.println(supp.get());

		// BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
		BinaryOperator<String> bina = (x, y) -> {
			System.out.println(x + "====" + y);
			return y;
		};
		System.out.println("+++" + bina.apply("hello1 ", "world5"));
	}

}
