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
		
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

	}
	
	@Test
	public void test2(){
		//自定义格式化器
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //获取当前日期和时间
        LocalDateTime ldt=LocalDateTime.now();

        //使用系统提供的格式来格式化
        String strDate= ldt.format(DateTimeFormatter.ISO_DATE);
        System.out.println("使用默认的格式："+strDate);//使用默认的格式：2017-11-04

        //第一种自定义格式化方式
        String strMyDateTime= ldt.format(dtf);
        System.out.println("自定义格式化:"+strMyDateTime);//自定义格式化:2017-11-04 14:30:36

        //第二种自定义格式化方式
        String strMyDateTime2=dtf.format(ldt);
        System.out.println("自定义格式化2:"+strMyDateTime2);//自定义格式化2:2017-11-04 14:30:36

        //使用自定义的格式来反格式化字符串
        String strDateMe="2017-11-02 15:30:22";
        LocalDateTime ldtMe= ldt.parse(strDateMe,dtf);
        System.out.println(ldtMe);//2017-11-02T15:30:22
	}
}
