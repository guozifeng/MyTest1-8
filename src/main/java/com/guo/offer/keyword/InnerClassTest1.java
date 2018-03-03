package com.guo.offer.keyword;

public class InnerClassTest1 {
    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.new Inner().print();
    }
}

class Outter {
    private int a = 1;

    class Inner {
        private int a = 2;

        public void print() {
            int a = 3;
            System.out.println("�ֲ�������" + a);
            System.out.println("�ڲ��������" + this.a);
            System.out.println("�ⲿ�������" + Outter.this.a);
        }
    }
}