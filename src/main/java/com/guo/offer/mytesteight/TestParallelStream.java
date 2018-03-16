package com.guo.offer.mytesteight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TestParallelStream {

    public static void main(String[] args) {

        
    }
    
    public static void test1(){
        Integer[] intArray = {1, 2, 3, 11, 4, 5, 6, 7, 8, 0};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        //parallelStorage必须为线程安全的容器
        //List<Integer> parallelStorage = new ArrayList<>();
        //List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
        List<Integer> parallelStorage = new Vector<Integer>();
        listOfIntegers.parallelStream()
            // Don't do this! It uses a stateful lambda expression.
            .map(e -> {
                parallelStorage.add(e);
                return e;
            }).forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("--------1------");
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("---------2-----");
        System.out.println("Sleep 5 sec");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
    }

    public static void test2(){
        Integer[] intArray = {1, 2, 3, 11, 4, 5, 6, 7, 8, 0};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        //parallelStorage必须为线程安全的容器
        //List<Integer> parallelStorage = new ArrayList<>();
        //List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
        List<Integer> parallelStorage = new Vector<Integer>();
        listOfIntegers.parallelStream()
            // Don't do this! It uses a stateful lambda expression.
            .map(e -> {
                parallelStorage.add(e);
                return e;
            }).forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("--------1------");
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("---------2-----");
        System.out.println("Sleep 5 sec");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
    }
    
}
