package com.guo.offer.annotation3;

import java.util.Arrays;

/**
 * @author 巩聪 2015年8月9日15:12:04
 */
// 使用注解的默认值对类进行注解
@MyAnnotation
public class Person {

    // 使用注解对成员变量注入值
    @MyAnnotation(age = 25)
    private int age;
    @MyAnnotation(name = "kepus angleiu")
    private String name;
    @MyAnnotation(address = {"山东省", "滨州市", "惠民县", "辛店镇", "后王营村"})
    private String[] address;
    @MyAnnotation(sex = SexEnum.GG)
    private SexEnum sex;

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + ", address=" + Arrays.toString(address) + ", sex=" + sex + "]";
    }
}
