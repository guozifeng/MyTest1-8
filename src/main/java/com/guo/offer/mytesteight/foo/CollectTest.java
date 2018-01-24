package com.guo.offer.mytesteight.foo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {
	public static void main(String[] args) {
		List<Integer> collectList = Stream.of(1, 2, 3, 4, 1).collect(Collectors.toList());
		System.out.println("collectList: " + collectList);

		Set<Integer> collectSet = Stream.of(1, 2, 3, 4, 1).collect(Collectors.toSet());
		System.out.println("collectSet: " + collectSet);

		Optional<Integer> collectMaxBy = Stream.of(1, 2, 3, 4)
				.collect(Collectors.maxBy(Comparator.comparingInt(o -> o)));
		System.out.println("collectMaxBy:" + collectMaxBy.get());

		Map<Boolean, List<Integer>> collectParti = Stream.of(1, 2, 3, 4)
				.collect(Collectors.partitioningBy(it -> it % 2 == 0));
		System.out.println("collectParti : " + collectParti);

		Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4).collect(Collectors.groupingBy(it -> it > 3));
		System.out.println("collectGroup : " + collectGroup);

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		StringBuilder sb = new StringBuilder();

		for (Integer it : list) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(it);

		}
		System.out.println(sb.toString());

		String strJoin = Stream.of("1", "2", "3", "4").collect(Collectors.joining(",", "[", "]"));
		System.out.println("strJoin: " + strJoin);

		Map<Boolean, List<Integer>> collectParti1 = Stream.of(1, 2, 3, 4)
				.collect(Collectors.partitioningBy(it -> it % 2 == 0));

		System.out.println("collectParti1: " + collectParti1);

		Map<Boolean, Integer> mapSize = new HashMap<>();
		collectParti1.entrySet().forEach(entry -> {
			
			System.out.println("entry.getKey():"+entry.getKey()+"  entry.getValue():"+entry.getValue());
			mapSize.put(entry.getKey(), entry.getValue().size());
			
		});

		System.out.println("mapSize : " + mapSize);

		Map<Boolean, Long> partiCount = Stream.of(1, 2, 3, 4)
				.collect(Collectors.partitioningBy(it -> it.intValue() % 2 == 0, Collectors.counting()));
		System.out.println("partiCount: " + partiCount);
		
	}
}
