package com.guo.interview.questions;
 
/**
 * 
 * @author Administrator
 * @date 2018/01/06
 */
public class StringOfferTest1 {

    public static void main(String[] args) {

        /**
         * 
         * jdk1.7 以后的虚拟机：
         * 1、方法区将要由native memory实现
         * 2、运行时常量池已从方法区移除
         * 3、之前的方法区是由永久代实现的
         * 
         * 首次出现：str1.intern()返回字符串常量池对象的引用。
         * 不是首次出现：str1.intern()返回堆对象的引用。
         * 
         */
        String str2 = "SEUCalvin";//新加的一行代码，其余不变
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
        System.out.println(str1.intern() == "SEUCalvin");
    }

}
