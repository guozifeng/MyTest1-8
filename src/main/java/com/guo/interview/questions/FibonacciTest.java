package com.guo.interview.questions;

public class FibonacciTest {

    public static void main(String[] args) {
        // �õݹ鷽��
        System.out.println("��40���Შ���������ǣ�" + f(40));
        // �ǵݹ鷽��
        System.out.println("��40���Შ���������ǣ�" + ff(40));
    }

    // �õݹ飬�����Ҫ���Შ��������
    public static long f(int n) {
        if (n < 1) {
            System.out.println("�Ƿ�����");
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1; // ��һ�͵ڶ����Შ�������ֶ�Ϊ1
        } else {
            return f(n - 1) + f(n - 2); // ��������ʼ��ֵΪǰ���� ���ֵĺ�
        }
    }

    // �ǵݹ飬����Შ��������
    public static long ff(int n) {
        if (n < 1) {
            System.out.println("�Ƿ�����");
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1; // ��һ�͵ڶ����Შ�������ֶ�Ϊ1
        }
        long f1 = 1L, f2 = 1L, f = 0;
        // ��ѭ���ۼ�
        for (int i = 0; i < n - 2; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}
