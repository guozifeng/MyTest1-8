package com.guo.MyTest18;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.junit.Test;

/**
 * Java8����ʹ��
 * <p>
 * Instant��ʱ��� LocalDate������ʱ������� LocalTime���������ڵ�ʱ��
 * LocalDateTime����ʱ�������ڣ�����û�д�ʱ����ƫ���� ZonedDateTime����ʱ��������ʱ��
 */
public class DateClient {
	
	@Test
	public void test1() {
		
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy��MM��dd�� HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

	}
	
	@Test
	public void test2(){
		//�Զ����ʽ����
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //��ȡ��ǰ���ں�ʱ��
        LocalDateTime ldt=LocalDateTime.now();

        //ʹ��ϵͳ�ṩ�ĸ�ʽ����ʽ��
        String strDate= ldt.format(DateTimeFormatter.ISO_DATE);
        System.out.println("ʹ��Ĭ�ϵĸ�ʽ��"+strDate);//ʹ��Ĭ�ϵĸ�ʽ��2017-11-04

        //��һ���Զ����ʽ����ʽ
        String strMyDateTime= ldt.format(dtf);
        System.out.println("�Զ����ʽ��:"+strMyDateTime);//�Զ����ʽ��:2017-11-04 14:30:36

        //�ڶ����Զ����ʽ����ʽ
        String strMyDateTime2=dtf.format(ldt);
        System.out.println("�Զ����ʽ��2:"+strMyDateTime2);//�Զ����ʽ��2:2017-11-04 14:30:36

        //ʹ���Զ���ĸ�ʽ������ʽ���ַ���
        String strDateMe="2017-11-02 15:30:22";
        LocalDateTime ldtMe= ldt.parse(strDateMe,dtf);
        System.out.println(ldtMe);//2017-11-02T15:30:22
	}
}
