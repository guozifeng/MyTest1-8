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
         * jdk1.7 �Ժ���������
         * 1����������Ҫ��native memoryʵ��
         * 2������ʱ�������Ѵӷ������Ƴ�
         * 3��֮ǰ�ķ������������ô�ʵ�ֵ�
         * 
         * �״γ��֣�str1.intern()�����ַ��������ض�������á�
         * �����״γ��֣�str1.intern()���ضѶ�������á�
         * 
         */
        String str2 = "SEUCalvin";//�¼ӵ�һ�д��룬���಻��
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
        System.out.println(str1.intern() == "SEUCalvin");
    }

}
