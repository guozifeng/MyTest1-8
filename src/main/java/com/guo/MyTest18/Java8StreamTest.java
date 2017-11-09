package com.guo.MyTest18;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamTest {

	public static void main(String[] args) {
		
	}

	private static void Test5() {
		// 3 apple, 2 banana, others 1
		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

		// group by price
		Map<BigDecimal, List<Item>> groupByPriceMap = items.stream().collect(Collectors.groupingBy(Item::getPrice));

		System.out.println(groupByPriceMap);

		// group by price, uses 'mapping' to convert List<item> to Set<string>
		Map<BigDecimal, Set<String>> result = items.stream()
				.collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));

		System.out.println(result);
	}

	private static void Test4() {
		// 3 apple, 2 banana, others 1
		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

		Map<String, Long> counting = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

		System.out.println(counting);

		Map<String, Integer> sum = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

		System.out.println(sum);
	}

	private static void Test3() {
		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();

		// Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);
	}

	private static void Test2() {
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = (Map<String, Long>) items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);
	}

	private static void Test1() {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		String st = sdf.format(date);
		int i = ca.get(Calendar.DAY_OF_YEAR);
		int a = ca.get(Calendar.DAY_OF_MONTH);
		System.out.println("当前时间是：" + st + ";一年中的" + i + "一个月中的" + a);

		String collectDate = "171115";
		System.out.println(new Integer(collectDate.substring(4)));

		System.out.println(new Date());
	}
}