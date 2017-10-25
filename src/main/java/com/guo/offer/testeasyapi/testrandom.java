package com.guo.offer.testeasyapi;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 下面Random()的两种构造方法：
 * 
 * Random()：创建一个新的随机数生成器。
 * 
 * Random(long seed)：使用单个 long 种子创建一个新的随机数生成器。
 * 
 * 我们可以在构造Random对象的时候指定种子（这里指定种子有何作用，请接着往下看），如：Random r1 = new Random(20);
 * 
 * 或者默认当前系统时间的毫秒数作为种子数:Random r1 = new Random();
 * 
 * 需要说明的是：你在创建一个Random对象的时候可以给定任意一个合法的种子数，种子数只是随机算法的起源数字，和生成的随机数的区间没有任何关系。
 * 如下面的Java代码：
 * 
 * Random rand =new Random(25); int i; i=rand.nextInt(100);
 * 初始化时25并没有起直接作用（注意：不是没有起作用）,rand.nextInt(100);中的100是随机数的上限,产生的随机数为0-100的整数,
 * 不包括100。 关于Math类中的random方法
 * 其实在Math类中也有一个random方法，该random方法的工作是生成一个[0,1.0)区间的随机小数。
 * 通过阅读Math类的源代码可以发现，Math类中的random方法就是直接调用Random类中的nextDouble方法实现的。
 * 只是random方法的调用比较简单，所以很多程序员都习惯使用Math类的random方法来生成随机数字。
 * 
 * @author Administrator
 *
 */
public class testrandom {
	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() {
		System.out.println("Math.random()=" + Math.random());
		System.out.println("Math.random()=" + ((int) (Math.random() * 8) + 1));

		Random ran = new Random();
		System.out.println(ran.nextInt());// 生成一个int类型取值范围的随机数
		System.out.println(ran.nextInt(100));// 生成一个0-100的int类型的随机数
		System.out.println(ran.nextFloat());// 生成一个Float类型的随机数
		System.out.println(ran.nextDouble());// 生成一个Double类型的随机数
		/*
		 * 结果1： -405998184 81 0.7216265 0.8820657901017879
		 */
		Random r2 = new Random(50);// 种子为50的对象
		Random r3 = new Random(50);// 种子为50的对象
		System.out.println("r2.nextInt():" + r2.nextInt(50) + "-------r3.nextInt():" + r3.nextInt(50));
		// 如果两个Random对象种子数相同，那么他们生成的结果将是一样。可以使用当前时间最为种子：System.currentTimeMillis()

		System.out.println("---------------多线程环境下使用ThreadLocalRandom类，用法跟Random类基本类似---------------------");
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		System.out.println(tlr.nextInt(10, 50));// 生成一个10~50之间的随机数
	}
}
