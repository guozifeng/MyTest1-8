package com.guo.offer.testmath;

/**
 * 
 * Math类中提供了三个与取整有关的方法：ceil,floor,round, 这些方法的作用于它们的英文名称的含义相对应，
 * 例如：ceil的英文意义是天花板，该方法就表示向上取整， Math.ceil（11.3）的结果为12，
 * Math.ceil(-11.6)的结果为-11；
 * floor的英文是地板，该方法就表示向下取整，Math.floor(11.6)的结果是11， 
 * Math.floor(-11.4)的结果-12；
 * 最难掌握的是round方法，他表示“四舍五入”， 算法为Math.floor(x+0.5),
 * 即将原来的数字加上0.5后再向下取整，
 * 所以，Math.round(11.5)的结果是12，Math.round(-11.5)的结果为-11. 
 * Math.round( * )符合这样的规律：小数点后大于5全部加，等于5正数加，小于5全不加。 
 * 让我们看看JDK的说明： (1)public static long
 * round(double a) returns the closest long to the argument. the result is
 * rounded to an integer by adding 1/2, taking the floor of the result, and
 * casting the result to type long. in other words, the result is equal to the
 * value of the expression:
 * 
 * (long)math.floor(a + 0.5d)
 * 
 * (2)public static double floor(double a) returns the largest(closest to
 * positive infinity) double value that is not greater than the argument and is
 * equal to a mathematical integer.special cases: if the argument value is
 * already equal to a mathematical integer, then the result is the same as the
 * argument. if the argument is nan or an infinity or positive zero or negative
 * zero, then the result is the same as the argument.
 * 
 * parameters: a - a value. returns: the smallest (closest to negative infinity)
 * floating-point value that is not less than the argument and is equal to a
 * mathematical integer.
 * 
 * @author Administrator
 *
 */
public class TestMath {

	public TestMath() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		test1();
		test2();
	}
	public static void test1(){
		
		int i = 0;
		for (int j = 0; j < 10; j++) {
			i = i++;
		}
		System.out.println("i的最后结果" + i);

		int temp = i;
		// 做自增
		i = i++;
		System.out.println("i的最后结果" + temp);
		
	}
	public static void test2(){
		System.out.println(Math.round(-11.52));

		// Math.round():Java中的四舍五入函数

		System.out.println("Case1：小数点后第一位 = 5");

		System.out.println("正数：Math.round(11.5) = " + Math.round(11.5));// 12

		System.out.println("负数：Math.round(-11.5) = " + Math.round(-11.5));// -11

		System.out.println("Case2：小数点后第一位 < 5");

		System.out.println("正数：Math.round(11.49) = " + Math.round(11.49));// 11

		System.out.println("负数：Math.round(-11.49) = " + Math.round(-11.49));// -11

		System.out.println("Case3：小数点后第一位 > 5");

		System.out.println("正数：Math.round(11.69) = " + Math.round(11.69));// 12

		System.out.println("负数：Math.round(-11.69) = " + Math.round(-11.69));// -12

		System.out.println("结论：正数小数点后大于5则进位；负数小数点后小于以及等于5都舍去，大于5的则进位");

		System.out.println("也就是说：小数点后大于5全部加，等于5正数加，小于5全不加");
	}
	public static void test20(){
		System.out.println("90 度的正弦值：" + Math.sin(Math.PI / 2));
		System.out.println("0度的余弦值：" + Math.cos(0));
		System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
		System.out.println("1的反正切值： " + Math.atan(1));
		System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI / 2));
		System.out.println(Math.PI);
	}
}
