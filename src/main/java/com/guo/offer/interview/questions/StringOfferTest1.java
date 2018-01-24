package com.guo.offer.interview.questions;
 
/**
 * https://www.cnblogs.com/ydpvictor/archive/2012/09/09/2677260.html
 * @author Administrator
 * @date 2018/01/06
 */
public class StringOfferTest1 {

    public static void main(String[] args) {

        /**
         * 
         * jdk1.7 以后的虚拟机：
         * 1、在Java7之前，HotSpot虚拟机中将GC分代收集扩展到了方法区，使用永久代来实现了方法区。这个区域的内存回收目标主要是针对常量池的回收和对类型的卸载。但是在之后的HotSpot虚拟机实现中，逐渐开始将方法区从永久代移除。
         * 2、Java7中已经将运行时常量池从永久代移除，在Java 堆（Heap）中开辟了一块区域存放运行时常量池。
         * 3、而在Java8中，已经彻底没有了永久代，将方法区直接放在一个与堆不相连的本地内存区域，这个区域被叫做元空间。 
         * 
         * 
         * 首次出现：str1.intern()返回字符串常量池对象的引用。
         * 不是首次出现：str1.intern()返回堆对象的引用。
         * 
         * 
         */
        String str2 = "SEUCalvin";//新加的一行代码，其余不变
        //String str3 = new String("SEUCalvin");
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
        System.out.println(str1.intern() == "SEUCalvin");
    }

}
