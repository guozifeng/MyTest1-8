package com.guo.offer.annotation3;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 表示在生成文档的时候添加注解
@Documented
// 表示此注解可以被继承
@Inherited
// 表示此注解的声明周期是源码
@Retention(value = RetentionPolicy.RUNTIME)
// 表示此注解使用范围是类、成员变量、方法、参数、局部变量
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
    ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {
    // 定义注解的成员变量（属性），注意形式：以定义方法的形式定义变量
    public String name() default "巩聪";// 默认值为巩聪

    public int age() default 13;// 默认值为13岁

    public String[] address() default {"滨州", "哈尔滨", "北京"};// 定义有默认值的数组变量

    public SexEnum sex() default SexEnum.BNBN;// 定义有默认值的媒聚变量
}
