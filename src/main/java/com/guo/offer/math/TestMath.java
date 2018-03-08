package com.guo.offer.math;

import java.util.Random;

/**
 * 
 * Math类中提供了三个与取整有关的方法：ceil,floor,round, 这些方法的作用于 它们的英文名称的含义相对应， 例如：ceil的英文意义是天花板，该方法就表示向上取整， Math.ceil（11.3）的结果为12，
 * Math.ceil(-11.6)的结果为-11； floor的英文是地板，该方法就表示向下取整，Math.floor(11.6)的结果是11， Math.floor(-11.4)的结果-12；
 * 最难掌握的是round方法，他表示“四舍五入”， 算法为Math.floor(x+0.5), 即将原来的数字加上0.5后再向下取整，
 * 所以，Math.round(11.5)的结果是12，Math.round(-11.5)的结果为-11. Math.round( * )符合这样的规律：小数点后大于5全部加，等于5正数加，小于5全不加。
 * 
 * 
 * @author Administrator
 *
 */
public class TestMath {

    public static void main(String[] args) {
        test3();
    }

    public static String test4() {

        boolean flag = true;

        if (flag) {
            return "222";
        }

        return "333";
    }

    public static void test3() {
        Random R = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(R.nextInt(10));
        }

    }

    public static void test1() {
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

    public static void test2() {
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

    public static void test20() {
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI / 2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI / 2));
        System.out.println(Math.PI);
    }
}
