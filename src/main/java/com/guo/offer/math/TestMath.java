package com.guo.offer.math;

import java.util.Random;

/**
 * 
 * Math�����ṩ��������ȡ���йصķ�����ceil,floor,round, ��Щ������������ ���ǵ�Ӣ�����Ƶĺ������Ӧ�� ���磺ceil��Ӣ���������컨�壬�÷����ͱ�ʾ����ȡ���� Math.ceil��11.3���Ľ��Ϊ12��
 * Math.ceil(-11.6)�Ľ��Ϊ-11�� floor��Ӣ���ǵذ壬�÷����ͱ�ʾ����ȡ����Math.floor(11.6)�Ľ����11�� Math.floor(-11.4)�Ľ��-12��
 * �������յ���round����������ʾ���������롱�� �㷨ΪMath.floor(x+0.5), ����ԭ�������ּ���0.5��������ȡ����
 * ���ԣ�Math.round(11.5)�Ľ����12��Math.round(-11.5)�Ľ��Ϊ-11. Math.round( * )���������Ĺ��ɣ�С��������5ȫ���ӣ�����5�����ӣ�С��5ȫ���ӡ�
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
        System.out.println("i�������" + i);
        int temp = i;
        // ������
        i = i++;
        System.out.println("i�������" + temp);
    }

    public static void test2() {
        System.out.println(Math.round(-11.52));
        // Math.round():Java�е��������뺯��
        System.out.println("Case1��С������һλ = 5");
        System.out.println("������Math.round(11.5) = " + Math.round(11.5));// 12
        System.out.println("������Math.round(-11.5) = " + Math.round(-11.5));// -11
        System.out.println("Case2��С������һλ < 5");
        System.out.println("������Math.round(11.49) = " + Math.round(11.49));// 11
        System.out.println("������Math.round(-11.49) = " + Math.round(-11.49));// -11
        System.out.println("Case3��С������һλ > 5");
        System.out.println("������Math.round(11.69) = " + Math.round(11.69));// 12
        System.out.println("������Math.round(-11.69) = " + Math.round(-11.69));// -12
        System.out.println("���ۣ�����С��������5���λ������С�����С���Լ�����5����ȥ������5�����λ");
        System.out.println("Ҳ����˵��С��������5ȫ���ӣ�����5�����ӣ�С��5ȫ����");
    }

    public static void test20() {
        System.out.println("90 �ȵ�����ֵ��" + Math.sin(Math.PI / 2));
        System.out.println("0�ȵ�����ֵ��" + Math.cos(0));
        System.out.println("60�ȵ�����ֵ��" + Math.tan(Math.PI / 3));
        System.out.println("1�ķ�����ֵ�� " + Math.atan(1));
        System.out.println("��/2�ĽǶ�ֵ��" + Math.toDegrees(Math.PI / 2));
        System.out.println(Math.PI);
    }
}
