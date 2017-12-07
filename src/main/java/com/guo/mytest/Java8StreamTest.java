package com.guo.mytest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class Java8StreamTest {

	public static void main(String[] args) {
		Test5();

		//Test4();
		List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());
		System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));

		List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

		List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(() -> new ArrayList<Integer>(),
				(list, item) -> list.add(item), (list1, list2) -> list1.addAll(list2));

		System.out.println(numsWithoutNull);

	}

	private static void Test5() {
		// 3 apple, 2 banana, others 1
		
		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));
		
		List<Item> itemlist = new ArrayList<Item>();
		// group by price
		items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.groupingBy(Item::getQty)))
				.forEach((name, map) -> {
					System.out.println(name + "------------");
					map.forEach((a, b) -> {
						// System.out.println(a+"++++++++++"+b);
						Item aaa = b.stream().reduce(new Item(), (aa, bb) -> {
							aa.setName(bb.getName());
							if (aa.getPrice() != null) {
								aa.setPrice(aa.getPrice().add(bb.getPrice()));
							} else {
								aa.setPrice(bb.getPrice());
							}
							aa.setQty(bb.getQty());
							System.out.println(aa + "*************");

							return aa;
						});
						itemlist.add(aaa);
					});
				});

		System.out.println(itemlist);
		// group by price, uses 'mapping' to convert List<item> to Set<string>
		Map<BigDecimal, Set<String>> result = items.stream()
				.collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));

		System.out.println(result);

		Map<String, Map<Integer, List<Item>>> result1 = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.groupingBy(Item::getQty)));

		System.out.println(result1);

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

		Map<String, Map<Integer, BigDecimal>> sum1 = items.stream().collect(Collectors.groupingBy(Item::getName,
				Collectors.groupingBy(Item::getQty, Collectors.reducing(BigDecimal.ZERO, (Item a) -> {
					System.out.println(a);
					return a.getPrice();
				}, (x, y) -> x.add(y)))));

		System.out.println(sum1);

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
		SimpleDateFormat sdf = new SimpleDateFormat("");

		String st = sdf.format(date);
		int i = ca.get(Calendar.DAY_OF_YEAR);
		int a = ca.get(Calendar.DAY_OF_MONTH);

		String collectDate = "171115";
		System.out.println(new Integer(collectDate.substring(4)));

		System.out.println(new Date());
	}
}