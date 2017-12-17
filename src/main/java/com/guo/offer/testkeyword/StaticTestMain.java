package com.guo.offer.testkeyword;

public class StaticTestMain {
    public static void main(String[] args) {

        System.out.println(StaticTest.a);
        
        StaticTest testOne = new StaticTest();
        System.out.println(testOne.a);
        
        StaticTest testTwo = new StaticTest();
        
        System.out.println(testOne.a);
        System.out.println(testTwo.a);

    }
}
