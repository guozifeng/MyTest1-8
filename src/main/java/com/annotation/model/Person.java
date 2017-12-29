package com.annotation.model;

import java.util.Arrays;

import com.annotation.annotation.MyAnnotation;

/**
 * @author ���� 2015��8��9��15:12:04
 */
// ʹ��ע���Ĭ��ֵ�������ע��
@MyAnnotation
public class Person {

    // ʹ��ע��Գ�Ա����ע��ֵ
    @MyAnnotation(age = 25)
    private int age;
    @MyAnnotation(name = "kepus angleiu")
    private String name;
    @MyAnnotation(address = {"ɽ��ʡ", "������", "������", "������", "����Ӫ��"})
    private String[] address;
    @MyAnnotation(sex = SexEnum.GG)
    private SexEnum sex;

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + ", address=" + Arrays.toString(address) + ", sex=" + sex + "]";
    }
}
