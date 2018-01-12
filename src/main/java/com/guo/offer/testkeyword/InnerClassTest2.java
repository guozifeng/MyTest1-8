package com.guo.offer.testkeyword;

public class InnerClassTest2 {

    private static String name = "woobo";

    private String num = "X001";

    static class Person {

        // ��̬�ڲ��������public,protected,private����
        // ��̬�ڲ����п��Զ��徲̬���߷Ǿ�̬�ĳ�Ա

        private String address = "China";
        private static String x = "as";
        public String mail = "kongbowoo@yahoo.com.cn";// �ڲ��๫�г�Ա

        public void display() {

            // System.out.println(num);//����ֱ�ӷ����ⲿ��ķǾ�̬��Ա
            // ��̬�ڲ��಻�ܷ����ⲿ��ķǾ�̬��Ա(�����Ǿ�̬�����ͷǾ�̬����)

            System.out.println(name);

            // ֻ��ֱ�ӷ����ⲿ��ľ�̬��Ա
            // ��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա(������̬�����;�̬����)

            System.out.println("Inner " + address);
            System.out.println("Inner " + x);
            // ���ʱ��ڲ����Ա��

        }
    }

    public void printInfo() {

        Person person = new Person();

        // �ⲿ������ڲ���ķǾ�̬��Ա:ʵ�����ڲ��༴��

        person.display();

        // System.out.println(mail);//���ɷ���
        // System.out.println(address);//���ɷ���

        System.out.println(person.address);// ���Է����ڲ����˽�г�Ա
        System.out.println(Person.x);// �ⲿ������ڲ���ľ�̬��Ա���ڲ���.��̬��Ա
        System.out.println(person.mail);// ���Է����ڲ���Ĺ��г�Ա

    }

    public static void main(String[] args) {

        InnerClassTest2 staticTest = new InnerClassTest2();

        staticTest.printInfo();

    }
}