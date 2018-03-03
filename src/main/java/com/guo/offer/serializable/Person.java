package com.guo.offer.serializable;

import java.io.Serializable;

/**
 * <p>
 * ClassName: Person
 * <p>
 * <p>
 * Description:测试对象序列化和反序列化
 * <p>
 * 
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 下午02:33:25
 */
public class Person implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = -1266184428444814131L;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String sex;

}
