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
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy��MM��dd�� HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

	}
}
