package com.guo.offer.interview.questions;

public class TryCatchTest {

    public static void main(String[] args) {
        System.out.println(test1());
    }

    private static Integer test1() {
        try {
            System.out.println("catch is main1");
            System.out.println(1 / 0);
            System.out.println("catch is main2");
            return 3;
        } catch (Exception e) {
            System.out.println("catch is begin");
            return 1;
        } finally {
            System.out.println("finally is begin");
            return 2;
        }
        // return 4;
    }

}
