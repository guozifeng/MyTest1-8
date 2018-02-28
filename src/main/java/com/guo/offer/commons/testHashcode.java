package com.guo.offer.commons;

public class testHashcode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object o = new Object();
        Object o1 = new Object();
        System.out.println(o.hashCode());
        System.out.println(o1.hashCode());
        System.out.println(o.equals(o1));
        
        System.out.println(o);
        System.out.println(o1);
    }

}
