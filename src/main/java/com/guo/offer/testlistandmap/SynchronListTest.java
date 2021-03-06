package com.guo.offer.testlistandmap;

import java.util.ArrayList;
import java.util.Iterator;

public class SynchronListTest {
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        final Byte[] b = new Byte[0];
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (b) {
                    Iterator<Integer> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Integer integer = iterator.next();
                        System.out.println(integer + "  " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (b) {
                    Iterator<Integer> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Integer integer = iterator.next();
                        if (integer == 2) {
                            iterator.remove();
                        }
                    }
                }

            };
        };
        thread2.start();
        thread1.start();
    }
}