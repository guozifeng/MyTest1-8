package com.guo.mytesteight.foo;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * http://blog.csdn.net/IO_Field/article/details/54971608 reduce
 * ��������ʵ�ִ�Stream������һ��ֵ�������ɵ�ֵ��������ģ����Ǹ���ָ���ļ���ģ�͡����磬֮ǰ�ᵽcount��min��max��
 * ������Ϊ���ö��������׼���С���ʵ�ϣ���Щ��������reduce������
 * 
 * reduce����������override�ķ�����
 * 
 * Optional<T> reduce(BinaryOperator<T> accumulator); T reduce(T identity,
 * BinaryOperator<T> accumulator); <U> U reduce(U identity,BiFunction<U, ? super
 * T, U> accumulator,BinaryOperator<U> combiner);
 * �����ȿ���һ�����Σ������һ�������ӿ�BinaryOperator<T>��������ӿ��ּ̳���BiFunction<T, T,
 * T>.��BinaryOperator�ӿ��У��ֶ�����������̬����minBy��maxBy�����������Ȳ�����������̬���������˽�reduce�Ĳ�����
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
 *                      8 9 10 11 12 13 14 15 ��ʹ��ʱ�����ǿ���ʹ��Lambada���ʽ����ʾ
 * 
 *                      BinaryOperator�ӿڣ����Կ���reduce��������һ�����������������������������һ���������ϴκ���ִ�еķ���ֵ��Ҳ��Ϊ�м��������ڶ���������stream�е�Ԫ�أ����������������ֵ��ӣ��õ��ĺͻᱻ��ֵ���´�ִ����������ĵ�һ��������Ҫע����ǣ���һ��ִ�е�ʱ���һ��������ֵ��Stream�ĵ�һ��Ԫ�أ��ڶ���������Stream�ĵڶ���Ԫ�ء������������ֵ������Optional��
 * 
 *                      Optional accResult = Stream.of(1, 2, 3, 4) .reduce((acc,
 *                      item) -> { System.out.println("acc : " + acc); acc +=
 *                      item; System.out.println("item: " + item);
 *                      System.out.println("acc+ : " + acc);
 *                      System.out.println("--------"); return acc; });
 *                      System.out.println("accResult: " + accResult.get());
 *                      System.out.println("--------"); // �����ӡ -------- acc : 1
 *                      item: 2 acc+ : 3 -------- acc : 3 item: 3 acc+ : 6
 *                      -------- acc : 6 item: 4 acc+ : 10 -------- accResult:
 *                      10 -------- 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
 *                      19 20 21 22 23 24 25 26 27 28 ����дͼƬ����
 * 
 *                      ���������ڶ������Σ����һ�ֱ�����ͬ���Ƕ������һ��BinaryOperator�����ӿڣ���ͬ����������һ��identity����������ָ��Streamѭ���ĳ�ʼֵ�����StreamΪ�գ���ֱ�ӷ��ظ�ֵ����һ���棬�÷������᷵��Optional����Ϊ�÷����������null��
 * 
 *                      int accResult = Stream.of(1, 2, 3, 4) .reduce(0, (acc,
 *                      item) -> { System.out.println("acc : " + acc); acc +=
 *                      item; System.out.println("item: " + item);
 *                      System.out.println("acc+ : " + acc);
 *                      System.out.println("--------"); return acc; });
 *                      System.out.println("accResult: " + accResult);
 *                      System.out.println("--------"); // �����ӡ acc : 0 item: 1
 *                      acc+ : 1 -------- acc : 1 item: 2 acc+ : 3 -------- acc
 *                      : 3 item: 3 acc+ : 6 -------- acc : 6 item: 4 acc+ : 10
 *                      -------- accResult: 10 -------- 1 2 3 4 5 6 7 8 9 10 11
 *                      12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
 *                      31 �Ӵ�ӡ������Կ�����reduceǰ���ֱ��Σ���Ϊ���ܲ�����ͬ����ִ�еĲ���Ҳ����Ӧ�仯��
 * 
 *                      ����1��δ�����ʼֵ���Ӷ���һ��ִ�е�ʱ���һ��������ֵ��Stream�ĵ�һ��Ԫ�أ��ڶ���������Stream�ĵڶ���Ԫ��
 *                      ����2�������˳�ʼֵ���Ӷ���һ��ִ�е�ʱ���һ��������ֵ�ǳ�ʼֵ���ڶ���������Stream�ĵ�һ��Ԫ��
 *                      ���ڵ����ֱ��Σ������ȿ����������ĺ��壬��һ����������ʵ��u��������Ҫ���ص�U���Ͷ���ĳ�ʼ��ʵ��u���ڶ��������ۼ���accumulator������ʹ�ö�Ԫ?���ʽ������Ԫlambda���ʽ������������u���ۼ����������Դt���߼�������(u,t)->u.sum(t),��ʱlambda���ʽ���в��б��Ƿ���ʵ��u�ͱ����ļ���Ԫ��t������������u���ۼ�t�����������������combiner��ͬ���Ƕ�Ԫ?���ʽ��(u,t)->u���ڹٷ��ĵ�������ôһ�ν��ܣ�
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
 *                      ��Ϊreduce�ı��εĵ�һ������������ʵ�ʷ���ʵ�����������ͣ�ͬʱ��Ϊһ������Ҳ������ζ�Ÿñ��εĿ��Է����������͵����ݡ��������ĵ����ܵ�������˼����ǵ������������������������ֵ����������ֵ������ڶ���������������ݣ�Ҳ����˵�������õĽ����һ���ġ���������϶����Ի�ĵط���������������������������ģ������ȿ�һ�δ��룬Ϊ�˱����˽����е�Ե�ɣ���û��ʹ��Lambda���ʽ��
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
 *           System.out.println("accResult_: " + accResult_); // �����ӡ item: 1
 *           acc+ : [1] BiFunction item: 2 acc+ : [1, 2] BiFunction item: 3 acc+
 *           : [1, 2, 3] BiFunction item: 4 acc+ : [1, 2, 3, 4] BiFunction
 *           accResult_: [1, 2, 3, 4] accResult_: 10 1 2 3 4 5 6 7 8 9 10 11 12
 *           13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34
 *           35 36 37 38 39 40
 *           ����ʾ�������У����ݸ���һ��������ArrayList,�ڵڶ������������д�ӡ�ˡ�BiFunction�������ڵ����������ӿ��д�ӡ�˺����ӿ��д�ӡ�ˡ�BinaryOperator��.���ǣ�����ӡ�����ֻ�Ǵ�ӡ�ˡ�BiFunction������û�д�ӡ��BinaryOperator����˵������������������û��ִ�С���������֪���˸ñ��ο��Է����������͵����ݡ����ڵ���������������Ϊʲôû��ִ�У��տ�ʼ��ʱ��Ҳ��û�п���������ɶ��˼�أ��������������Ϊ���ص��������ͣ����˺ü����ĵ�Ҳ��һͷ��ˮ����
 *           java8
 *           reduce�����еĵ���������combiner��ʲô���ã������ҵ��˴𰸣�Stream��֧�ֲ��������ģ�Ϊ�˱��⾺��������reduce�̶߳����ж�����result��combiner���������ںϲ�ÿ���̵߳�result�õ����ս������Ҳ˵�����˵����������������������ͱ���Ϊ�������������ˡ�
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
