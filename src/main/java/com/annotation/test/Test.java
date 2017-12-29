package com.annotation.test;

import java.lang.reflect.Field;

import com.annotation.annotation.MyAnnotation;
import com.annotation.model.Person;

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) throws Exception {
        // 定义person，此时person对象没有任何值
        Person person = new Person();
        // 定义person对象的反射
        Class c = Class.forName("com.kepus.model.Person");

        // 在类层面上查看是否有注解（使用的注解的默认值）
        // 判断此反射上面是不是有MyAnnotation注解
        if (c.isAnnotationPresent(MyAnnotation.class)) {
            // 取得此反射上面的MyAnnotation注解
            MyAnnotation ma = (MyAnnotation)c.getAnnotation(MyAnnotation.class);
            // 遍历c反射上面的所有属性，并通过注解中的值给其赋值
            Field[] fields = c.getDeclaredFields();
            String fieldName = null;
            for (Field field : fields) {
                // 将其private属性设置为可以访问
                field.setAccessible(true);
                fieldName = field.getName();
                // 将成员变量的值设置成相应的注解的值
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

        // 在成员层面上产看是否有注解（使用注入的值）
        // 获取所有的成员变量的反射
        Field[] fieldArr = c.getDeclaredFields();
        String fieldName = null;
        for (Field field : fieldArr) {
            // 设置变量名
            fieldName = field.getName();
            // 设置私有变量可以访问
            field.setAccessible(true);
            // 判断当前变量上面是否有MyAnnotation的注解
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                // 得到注解
                MyAnnotation ma = field.getAnnotation(MyAnnotation.class);
                // 将成员变量的值设置成相应的注解的值
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
