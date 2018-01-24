package com.guo.offer.annotation3;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// ��ʾ�������ĵ���ʱ�����ע��
@Documented
// ��ʾ��ע����Ա��̳�
@Inherited
// ��ʾ��ע�������������Դ��
@Retention(value = RetentionPolicy.RUNTIME)
// ��ʾ��ע��ʹ�÷�Χ���ࡢ��Ա�������������������ֲ�����
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
    ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {
    // ����ע��ĳ�Ա���������ԣ���ע����ʽ���Զ��巽������ʽ�������
    public String name() default "����";// Ĭ��ֵΪ����

    public int age() default 13;// Ĭ��ֵΪ13��

    public String[] address() default {"����", "������", "����"};// ������Ĭ��ֵ���������

    public SexEnum sex() default SexEnum.BNBN;// ������Ĭ��ֵ��ý�۱���
}
