package com.guo.offer.mytesteight;

import java.util.Optional;

public class testOptional2 {
    public static void main(String args[]) {

        testOptional2 java8Tester = new testOptional2();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - ������Ϊ null ����
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional<Integer> c = Optional.of(value1);
        // System.out.println(c.isPresent());

        // Optional.of - ������ݵĲ����� null���׳��쳣 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - �ж�ֵ�Ƿ����

        System.out.println("��һ������ֵ����: " + a.isPresent());
        System.out.println("�ڶ�������ֵ����: " + b.isPresent());

        // Optional.orElse - ���ֵ���ڣ������������򷵻�Ĭ��ֵ
        Integer value1 = a.orElse(new Integer(0));

        // Optional.get - ��ȡֵ��ֵ��Ҫ����
        Integer value2 = b.get();
        return value1 + value2;
    }
}