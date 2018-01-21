package com.guo.interview.questions;

public class FibonacciTest {

    public static void main(String[] args) {
        // 用递归方法
        System.out.println("第40个裴波那契数字是：" + f(40));
        // 非递归方法
        System.out.println("第40个裴波那契数字是：" + ff(40));
    }

    // 用递归，获得需要的裴波那契数字
    public static long f(int n) {
        if (n < 1) {
            System.out.println("非法参数");
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1; // 第一和第二个裴波那契数字都为1
        } else {
            return f(n - 1) + f(n - 2); // 第三个开始，值为前两个 数字的和
        }
    }

    // 非递归，获得裴波那契数字
    public static long ff(int n) {
        if (n < 1) {
            System.out.println("非法参数");
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1; // 第一和第二个裴波那契数字都为1
        }
        long f1 = 1L, f2 = 1L, f = 0;
        // 用循环累加
        for (int i = 0; i < n - 2; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}
