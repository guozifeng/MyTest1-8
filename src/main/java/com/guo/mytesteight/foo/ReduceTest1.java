package com.guo.mytesteight.foo;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * http://blog.csdn.net/IO_Field/article/details/54971608 reduce
 * 操作可以实现从Stream中生成一个值，其生成的值不是随意的，而是根据指定的计算模型。比如，之前提到count、min和max方
 * 法，因为常用而被纳入标准库中。事实上，这些方法都是reduce操作。
 * 
 * reduce方法有三个override的方法：
 * 
 * Optional<T> reduce(BinaryOperator<T> accumulator); T reduce(T identity,
 * BinaryOperator<T> accumulator); <U> U reduce(U identity,BiFunction<U, ? super
 * T, U> accumulator,BinaryOperator<U> combiner);
 * 我们先看第一个变形，其接受一个函数接口BinaryOperator<T>，而这个接口又继承于BiFunction<T, T,
 * T>.在BinaryOperator接口中，又定义了两个静态方法minBy和maxBy。这里我们先不管这两个静态方法，先了解reduce的操作。
 * 
 * @FunctionalInterface public interface BinaryOperator<T> extends
 *                      BiFunction<T,T,T> {
 * 
 *                      public static <T> BinaryOperator<T> minBy(Comparator<?
 *                      super T> comparator) {
 *                      Objects.requireNonNull(comparator); return (a, b) ->
 *                      comparator.compare(a, b) <= 0 ? a : b; }
 * 
 * 
 *                      public static <T> BinaryOperator<T> maxBy(Comparator<?
 *                      super T> comparator) {
 *                      Objects.requireNonNull(comparator); return (a, b) ->
 *                      comparator.compare(a, b) >= 0 ? a : b; } } 1 2 3 4 5 6 7
 *                      8 9 10 11 12 13 14 15 在使用时，我们可以使用Lambada表达式来表示
 * 
 *                      BinaryOperator接口，可以看到reduce方法接受一个函数，这个函数有两个参数，第一个参数是上次函数执行的返回值（也称为中间结果），第二个参数是stream中的元素，这个函数把这两个值相加，得到的和会被赋值给下次执行这个函数的第一个参数。要注意的是：第一次执行的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素。这个方法返回值类型是Optional，
 * 
 *                      Optional accResult = Stream.of(1, 2, 3, 4) .reduce((acc,
 *                      item) -> { System.out.println("acc : " + acc); acc +=
 *                      item; System.out.println("item: " + item);
 *                      System.out.println("acc+ : " + acc);
 *                      System.out.println("--------"); return acc; });
 *                      System.out.println("accResult: " + accResult.get());
 *                      System.out.println("--------"); // 结果打印 -------- acc : 1
 *                      item: 2 acc+ : 3 -------- acc : 3 item: 3 acc+ : 6
 *                      -------- acc : 6 item: 4 acc+ : 10 -------- accResult:
 *                      10 -------- 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
 *                      19 20 21 22 23 24 25 26 27 28 这里写图片描述
 * 
 *                      下面来看第二个变形，与第一种变形相同的是都会接受一个BinaryOperator函数接口，不同的是其会接受一个identity参数，用来指定Stream循环的初始值。如果Stream为空，就直接返回该值。另一方面，该方法不会返回Optional，因为该方法不会出现null。
 * 
 *                      int accResult = Stream.of(1, 2, 3, 4) .reduce(0, (acc,
 *                      item) -> { System.out.println("acc : " + acc); acc +=
 *                      item; System.out.println("item: " + item);
 *                      System.out.println("acc+ : " + acc);
 *                      System.out.println("--------"); return acc; });
 *                      System.out.println("accResult: " + accResult);
 *                      System.out.println("--------"); // 结果打印 acc : 0 item: 1
 *                      acc+ : 1 -------- acc : 1 item: 2 acc+ : 3 -------- acc
 *                      : 3 item: 3 acc+ : 6 -------- acc : 6 item: 4 acc+ : 10
 *                      -------- accResult: 10 -------- 1 2 3 4 5 6 7 8 9 10 11
 *                      12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
 *                      31 从打印结果可以看出，reduce前两种变形，因为接受参数不同，其执行的操作也有相应变化：
 * 
 *                      变形1，未定义初始值，从而第一次执行的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素
 *                      变形2，定义了初始值，从而第一次执行的时候第一个参数的值是初始值，第二个参数是Stream的第一个元素
 *                      对于第三种变形，我们先看各个参数的含义，第一个参数返回实例u，传递你要返回的U类型对象的初始化实例u，第二个参数累加器accumulator，可以使用二元?表达式（即二元lambda表达式），声明你在u上累加你的数据来源t的逻辑，例如(u,t)->u.sum(t),此时lambda表达式的行参列表是返回实例u和遍历的集合元素t，函数体是在u上累加t，第三个参数组合器combiner，同样是二元?表达式，(u,t)->u。在官方文档上有这么一段介绍，
 * 
 *                      U result = identity;
 * 
 *                      for (T element : this stream)
 * 
 *                      result = accumulator.apply(result, element)
 * 
 *                      return result;
 * 
 *                      but is not constrained to execute sequentially.
 * 
 *                      The identity value must be an identity for the combiner
 *                      function. This means that for all u, combiner(identity,
 *                      u) is equal to u. Additionally, the combiner function
 *                      must be compatible with the accumulator function; for
 *                      all u and t, the following must hold:
 * 
 *                      combiner.apply(u, accumulator.apply(identity, t)) ==
 *                      accumulator.apply(u, t)
 *                      因为reduce的变形的第一个参数类型是实际返回实例的数据类型，同时其为一个泛型也就是意味着该变形的可以返回任意类型的数据。从上面文档介绍的字面意思解读是第三个参数函数用来组合两个值，而这两个值必须与第二个函数参数相兼容，也就是说它们所得的结果是一样的。看到这里肯定有迷惑的地方，第三个参数到底是用来干嘛的？我们先看一段代码，为了便于了解其中的缘由，并没有使用Lambda表达式，
 * 
 *                      ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4)
 *                      .reduce(new ArrayList<Integer>(), new
 *                      BiFunction<ArrayList<Integer>, Integer,
 *                      ArrayList<Integer>>() {
 * @Override public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer
 *           item) {
 * 
 *           acc.add(item); System.out.println("item: " + item);
 *           System.out.println("acc+ : " + acc);
 *           System.out.println("BiFunction"); return acc; } }, new
 *           BinaryOperator<ArrayList<Integer>>() {
 * @Override public ArrayList<Integer> apply(ArrayList<Integer> acc,
 *           ArrayList<Integer> item) { System.out.println("BinaryOperator");
 *           acc.addAll(item); System.out.println("item: " + item);
 *           System.out.println("acc+ : " + acc);
 *           System.out.println("--------"); return acc; } });
 *           System.out.println("accResult_: " + accResult_); // 结果打印 item: 1
 *           acc+ : [1] BiFunction item: 2 acc+ : [1, 2] BiFunction item: 3 acc+
 *           : [1, 2, 3] BiFunction item: 4 acc+ : [1, 2, 3, 4] BiFunction
 *           accResult_: [1, 2, 3, 4] accResult_: 10 1 2 3 4 5 6 7 8 9 10 11 12
 *           13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34
 *           35 36 37 38 39 40
 *           首先示例代码中，传递给第一个参数是ArrayList,在第二个函数参数中打印了“BiFunction”，而在第三个参数接口中打印了函数接口中打印了”BinaryOperator“.可是，看打印结果，只是打印了“BiFunction”，而没有打印”BinaryOperator“，说明第三个函数参数病没有执行。这里我们知道了该变形可以返回任意类型的数据。对于第三个函数参数，为什么没有执行，刚开始的时候也是没有看懂到底是啥意思呢，而且其参数必须为返回的数据类型？看了好几遍文档也是一头雾水。在
 *           java8
 *           reduce方法中的第三个参数combiner有什么作用？这里找到了答案，Stream是支持并发操作的，为了避免竞争，对于reduce线程都会有独立的result，combiner的作用在于合并每个线程的result得到最终结果。这也说明了了第三个函数参数的数据类型必须为返回数据类型了。
 * @author Administrator
 *
 */
public class ReduceTest1 {

	public static void main(String[] args) {
		test3();
		System.out.println();
		test2();
		System.out.println();
		test1();
	}

	public static void test3() {
		ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4).reduce(new ArrayList<Integer>(),
				new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
					@Override
					public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {

						acc.add(item);
						System.out.println("item: " + item);
						System.out.println("acc+ : " + acc);
						System.out.println("BiFunction");
						return acc;
					}
				}, new BinaryOperator<ArrayList<Integer>>() {
					@Override
					public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
						System.out.println("BinaryOperator");
						acc.addAll(item);
						System.out.println("item: " + item);
						System.out.println("acc+ : " + acc);
						System.out.println("--------");
						return acc;
					}
				});
		System.out.println("accResult_: " + accResult_);
	}

	public static void test2() {
		int accResult = Stream.of(1, 2, 3, 4).reduce(0, (acc, item) -> {
			System.out.println("acc : " + acc);
			acc += item;
			System.out.println("item: " + item);
			System.out.println("acc+ : " + acc);
			System.out.println("--------");
			return acc;
		});
		System.out.println("accResult: " + accResult);
		System.out.println("--------");
	}

	public static void test1() {

		Optional<Integer> accResult = Stream.of(1, 2, 3, 4).reduce((acc, item) -> {
			System.out.println("acc : " + acc);
			acc += item;
			System.out.println("item: " + item);
			System.out.println("acc+ : " + acc);
			System.out.println("--------");
			return acc;
		});
		System.out.println("accResult: " + accResult.get());
		System.out.println("--------");
	}

}
