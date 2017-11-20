package com.guo.MyTest18;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.junit.Test;

/**
 * Java8日期使用
 * <p>
 * Instant：时间戳 LocalDate：不带时间的日期 LocalTime：不带日期的时间
 * LocalDateTime：含时间与日期，不过没有带时区的偏移量 ZonedDateTime：带时区的完整时间
 */
public class DateClient {
	
	@Test
	public void test1() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

	}
}
