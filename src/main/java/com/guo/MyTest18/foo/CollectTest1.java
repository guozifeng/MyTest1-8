package com.guo.MyTest18.foo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class CollectTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
		System.out.println("-------------");
		List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(() -> new ArrayList<Integer>(),
				(list, item) -> {
					list.add(item);

					System.out.println("item = " + item);
					System.out.println("list = " + list);

				}, (list1, list2) -> {
					list1.addAll(list2);
					System.out.println("list1 = " + list1);
					System.out.println("list2 = " + list2);
				});
		System.out.println(numsWithoutNull);

		List<?> list = Stream.of(1, 2, 3, 4).filter(p -> p > 2).collect(Collectors.toList());
		System.out.println(list);
		System.out.println();

		Person p1 = new Person("guo", 11);
		List<Person> people = new ArrayList<Person>();
		people.add(p1);

		Map result = people.stream().collect(HashMap::new, (map, p) -> map.put(p.name, p.age), Map::putAll);
		System.out.println(result);
		Map result1 = people.stream().collect(Collectors.toMap(p -> p.name, p -> p.age, (exsit, newv) -> newv));
		System.out.println(result1);

		List<Map> personToMap = people.stream().collect(ArrayList::new, (list1, p) -> {
			Map map = new HashMap<>();
			map.put("name", p.name);
			map.put("age", p.age);
			list1.add(map);
		}, List::addAll);
		
		System.out.println(personToMap);
	}

}
