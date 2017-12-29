package com.guo.parallelbook.chapter5;

public class DoubleCheckSingleton {

    static String a = "aa";

    static {
        System.out.println("DoubleCheckSingletonDoubleCheckSingleton");
    }

    private volatile static DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
        System.out.println("DoubleCheckSingleton is create");
    }

    public static DoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String args[]) {
        DoubleCheckSingleton a3 = DoubleCheckSingleton.getSingleton();
        DoubleCheckSingleton a4 = DoubleCheckSingleton.getSingleton();
        System.out.println(a3 == a4);

        DoubleCheckSingleton a5 = new DoubleCheckSingleton();
        System.out.println(a5 == a4);
    }
}
