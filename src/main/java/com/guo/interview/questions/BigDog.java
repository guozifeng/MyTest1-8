package com.guo.interview.questions;

/**
 * 
 * �ӳ�����̳и������࣬�������Ե��ø�����������Թ�����
 * 
 * @author Administrator
 * @date 2017/12/24
 * 
 */
abstract class Animal {
    private int age;

    public Animal(int age) {
        this.age = age;
        System.out.println("��ʼ��Animal");
    }

    public void move() {
        System.out.println("�ܲ�����" + this.age);
    }
}

abstract class Dog extends Animal {
    public Dog(int age) {
        super(age);// ȥ���ᱨ�쳣
        System.out.println("��ʼ��Dog");
    }

}

public class BigDog extends Dog {
    public BigDog() {
        super(10);
        System.out.println("��ʼ��BigDog");
    }

    public static void main(String[] args) {
        BigDog a = new BigDog();
        a.move();
    }
}
