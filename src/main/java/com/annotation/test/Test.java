package com.annotation.test;

import java.lang.reflect.Field;

import com.annotation.annotation.MyAnnotation;
import com.annotation.model.Person;

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) throws Exception {
        // ����person����ʱperson����û���κ�ֵ
        Person person = new Person();
        // ����person����ķ���
        Class c = Class.forName("com.kepus.model.Person");

        // ��������ϲ鿴�Ƿ���ע�⣨ʹ�õ�ע���Ĭ��ֵ��
        // �жϴ˷��������ǲ�����MyAnnotationע��
        if (c.isAnnotationPresent(MyAnnotation.class)) {
            // ȡ�ô˷��������MyAnnotationע��
            MyAnnotation ma = (MyAnnotation)c.getAnnotation(MyAnnotation.class);
            // ����c����������������ԣ���ͨ��ע���е�ֵ���丳ֵ
            Field[] fields = c.getDeclaredFields();
            String fieldName = null;
            for (Field field : fields) {
                // ����private��������Ϊ���Է���
                field.setAccessible(true);
                fieldName = field.getName();
                // ����Ա������ֵ���ó���Ӧ��ע���ֵ
                if ("age".equals(fieldName)) {
                    field.set(person, ma.age());
                } else if ("name".equals(fieldName)) {
                    field.set(person, ma.name());
                } else if ("address".equals(fieldName)) {
                    field.set(person, ma.address());
                } else if ("sex".equals(fieldName)) {
                    field.set(person, ma.sex());
                }
            }
            System.out.println(person.toString());
        }

        // �ڳ�Ա�����ϲ����Ƿ���ע�⣨ʹ��ע���ֵ��
        // ��ȡ���еĳ�Ա�����ķ���
        Field[] fieldArr = c.getDeclaredFields();
        String fieldName = null;
        for (Field field : fieldArr) {
            // ���ñ�����
            fieldName = field.getName();
            // ����˽�б������Է���
            field.setAccessible(true);
            // �жϵ�ǰ���������Ƿ���MyAnnotation��ע��
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                // �õ�ע��
                MyAnnotation ma = field.getAnnotation(MyAnnotation.class);
                // ����Ա������ֵ���ó���Ӧ��ע���ֵ
                if ("age".equals(fieldName)) {
                    field.set(person, ma.age());
                } else if ("name".equals(fieldName)) {
                    field.set(person, ma.name());
                } else if ("address".equals(fieldName)) {
                    field.set(person, ma.address());
                } else if ("sex".equals(fieldName)) {
                    field.set(person, ma.sex());
                }
            }
        }
        System.out.println(person.toString());
    }
}
