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
         * jdk1.7 �Ժ���������
         * 1����Java7֮ǰ��HotSpot������н�GC�ִ��ռ���չ���˷�������ʹ�����ô���ʵ���˷����������������ڴ����Ŀ����Ҫ����Գ����صĻ��պͶ����͵�ж�ء�������֮���HotSpot�����ʵ���У��𽥿�ʼ�������������ô��Ƴ���
         * 2��Java7���Ѿ�������ʱ�����ش����ô��Ƴ�����Java �ѣ�Heap���п�����һ������������ʱ�����ء�
         * 3������Java8�У��Ѿ�����û�������ô�����������ֱ�ӷ���һ����Ѳ������ı����ڴ�����������򱻽���Ԫ�ռ䡣 
         * 
         * 
         * �״γ��֣�str1.intern()�����ַ��������ض�������á�
         * �����״γ��֣�str1.intern()���ضѶ�������á�
         * 
         * 
         */
        String str2 = "SEUCalvin";//�¼ӵ�һ�д��룬���಻��
        //String str3 = new String("SEUCalvin");
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
        System.out.println(str1.intern() == "SEUCalvin");
    }

}
