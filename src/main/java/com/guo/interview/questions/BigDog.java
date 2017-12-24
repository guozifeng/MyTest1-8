package com.guo.interview.questions;

abstract class Animal {
    private int age;

    public Animal(int age) {
        this.age = age;
        System.out.println("初始化Animal");
    }

    public void move() {
        System.out.println("跑步数：" + this.age);
    }
}

abstract class Dog extends Animal {
    public Dog(int age) {
        super(age);// 去掉会报异常
        System.out.println("初始化Dog");
    }

}

public class BigDog extends Dog {
    public BigDog() {
        super(10);
        System.out.println("初始化BigDog");
    }

    public static void main(String[] args) {
        BigDog a = new BigDog();
        a.move();
    }
}
