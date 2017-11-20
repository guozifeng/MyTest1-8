package com.guo.MyTest18;

import org.junit.Test;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Java8����ʹ��
 * <p>
 * Instant��ʱ��� LocalDate������ʱ������� LocalTime���������ڵ�ʱ��
 * LocalDateTime����ʱ�������ڣ�����û�д�ʱ����ƫ���� ZonedDateTime����ʱ��������ʱ��
 */
public class DateClient {

	// 1-��ȡ���������
	@Test
	public void test1() {
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);
	}

	// 2-��ȡ��ǰ��������
	@Test
	public void test2() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
	}

	// 3-��ȡĳ���ض�������
	@Test
	public void test3() {
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);
	}

	// 4-������������Ƿ����
	@Test
	public void test4() {
		LocalDate today = LocalDate.now();
		LocalDate date1 = LocalDate.of(2014, 01, 14);
		if (date1.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date1);
		}
	}

	// 5-����ظ��¼�������˵����
	@Test
	public void test5() {
		LocalDate today = LocalDate.now();
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}
	}

	// 6-��ȡ��ǰʱ��
	@Test
	public void test6() {
		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);
	}

	// 7-����ʱ�������Сʱ��
	@Test
	public void test7() {
		LocalTime time = LocalTime.now();
		LocalTime newTime = time.plusHours(2); // adding two hours
		System.out.println("Time after 2 hours : " + newTime);
	}

	// 8-��ȡ1�ܺ������
	@Test
	public void test8() {
		LocalDate today = LocalDate.now();
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Today is : " + today);
		System.out.println("Date after 1 week : " + nextWeek);
	}

	// 9-һ��ǰ�������
	@Test
	public void test9() {
		LocalDate today = LocalDate.now();
		LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
		System.out.println("Date before 1 year : " + previousYear);
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Date after 1 year : " + nextYear);
	}

	// 10-��ͬʱ����ʱ��
	@Test
	public void test10() {
		// Returns the current time based on your system clock and set to UTC.
		Clock clock = Clock.systemUTC();
		System.out.println("Clock : " + clock);
		// Returns time based on system clock zone Clock defaultClock =
		Clock.systemDefaultZone();
		System.out.println("Clock : " + clock);
	}

	// 11-�ж�ĳ������������һ�����ڵ�ǰ�滹�Ǻ���
	@Test
	public void test11() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = LocalDate.of(2014, 1, 15);
		if (tomorrow.isAfter(today)) {
			System.out.println("Tomorrow comes after today");
		}
		LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
		if (yesterday.isBefore(today)) {
			System.out.println("Yesterday is day before today");
		}
	}

	// 12-����ͬ��ʱ��
	@Test
	public void test12() {
		ZoneId america = ZoneId.of("America/New_York");
		LocalDateTime localtDateAndTime = LocalDateTime.now();
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
		System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
	}

	// 13-��ʾ�̶������ڣ��������ÿ�����ʱ��
	@Test
	public void tese13() {
		YearMonth currentYearMonth = YearMonth.now();
		System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
		YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
	}

	// 14-��Java 8�м������
	@Test
	public void test14() {
		LocalDate today = LocalDate.now();
		if (today.isLeapYear()) {
			System.out.println("This year is Leap year");
		} else {
			System.out.println("2014 is not a Leap year");
		}
	}

	// 15-��������֮����������죬���ٸ���
	@Test
	public void test15() {
		LocalDate today = LocalDate.now();
		LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
		Period periodToNextJavaRelease = Period.between(today, java8Release);
		System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
	}

	// 16-��ʱ��ƫ������������ʱ��
	@Test
	public void test16() {
		LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
		ZoneOffset offset = ZoneOffset.of("+05:30");
		OffsetDateTime date = OffsetDateTime.of(datetime, offset);
		System.out.println("Date and Time with timezone offset in Java : " + date);
	}

	// 17-��ȡ��ǰʱ���
	@Test
	public void test17() {
		Instant timestamp = Instant.now();
		System.out.println("What is value of this instant " + timestamp);
	}

	// 18-ʹ��Ԥ����ĸ�ʽ���������ڽ��н���/��ʽ��
	@Test
	public void test18() {
		String dayAfterTommorrow = "20140116";
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
	}

	// 19-ʹ���Զ���ĸ�ʽ������������
	@Test
	public void test19() {
		String goodFriday = "Apr 18 2014";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
			LocalDate holiday = LocalDate.parse(goodFriday, formatter);
			System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
		} catch (DateTimeParseException ex) {
			System.out.printf("%s is not parsable!%n", goodFriday);
		}
	}

	// 20-�����ڽ��и�ʽ����ת�����ַ���
	@Test
	public void test20() {
		LocalDateTime arrivalDate = LocalDateTime.now();
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
			String landing = arrivalDate.format(format);
			System.out.printf("Arriving at : %s %n", landing);
		} catch (DateTimeException ex) {
			System.out.printf("%s can't be formatted!%n", arrivalDate);
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test21() {
	    // ��ȡԤ����ĸ�ʽ��DateTimeFormatter��Ԥ���˺ܶ��ָ�ʽ
	    DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
	    // ��ȡ��ǰ����ʱ��
	    LocalDate now = LocalDate.now();
	    // ָ����ʽ������ʽ����ʱ��
	    String strNow = now.format(dtf);
	    System.out.println(strNow);

	    // �Զ����ʽ
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy��MM��dd��");
	    String strNow2 = now.format(formatter);
	    System.out.println(strNow2);

	    // ���ַ���ת��������
	    LocalDate date = LocalDate.parse(strNow2, formatter);
	    System.out.println(date);
	    
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    System.out.println("Ĭ�ϸ�ʽ��: " + now);
	    System.out.println("�Զ����ʽ��: " + now.format(dateTimeFormatter));
	    LocalDateTime localDateTime = LocalDateTime.parse("2017-07-20 15:27:44", dateTimeFormatter);
	    System.out.println("�ַ���תLocalDateTime: " + localDateTime);
	}
}
