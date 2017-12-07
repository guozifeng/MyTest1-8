package com.guo.mytest;

import java.util.Optional;

public class testOptional {

	// 使用Optional，我们就可以把下面这样的代码进行改写。
	public static String getName0(User u) {
		if (u == null)
			return "Unknown";
		return u.name;
	}

	// 不过，千万不要改写成这副样子。
	public static String getName1(User u) {
		Optional<User> user = Optional.ofNullable(u);
		if (!user.isPresent())
			return "Unknown";
		return user.get().name;
	}

	// 这样改写非但不简洁，而且其操作还是和第一段代码一样。无非就是用isPresent方法来替代u==null。这样的改写并不是Optional正确的用法，我们再来改写一次。
	public static String getName2(User u) {
		return Optional.ofNullable(u).map(user -> user.name).orElse("Unknown");
	}

	public static String getChampionName(Competition comp) throws IllegalArgumentException {
		if (comp != null) {
			CompResult result = comp.getCompResult();
			if (result != null) {
				User champion = result.getUser();
				if (champion != null) {
					return champion.getName();
				}
			}
		}
		throw new IllegalArgumentException("The value of param comp isn't available.");
	}

	public static String getChampionName1(Competition comp) throws IllegalArgumentException {
		return Optional.ofNullable(comp).map(c -> c.getCompResult()).map(r -> r.getUser()).map(u -> u.getName())
				.orElseThrow(() -> new IllegalArgumentException("The value of param comp isn't available."));
	}

	public static void main(String args[]) {
		Competition comp = new Competition();
		CompResult cn = new CompResult();
		User u = new User();
		//u.setName("222");
		cn.setUser(u);
		//comp.setUser(u);
		comp.setCompResult(cn);

		System.out.println(getName0(u));
		System.out.println(getName1(u));
		System.out.println(getName2(u));
		System.out.println(getChampionName(comp));
		System.out.println(getChampionName1(comp));

		System.out.println();

		System.out.println(getName0(null));
		System.out.println(getName1(null));
		System.out.println(getName2(null));
		System.out.println(getChampionName(comp));
		System.out.println(getChampionName1(comp));
	}
}
