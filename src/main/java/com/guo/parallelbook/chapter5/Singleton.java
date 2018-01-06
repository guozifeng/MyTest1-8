package com.guo.parallelbook.chapter5;

/**
 * Created by 13 on 2017/5/6.
 */
public class Singleton {
    
    static String a = "aa";
    
    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}