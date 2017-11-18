package com.guo.MyTest18;

import java.util.Optional;

public class User {
	String name;

	public String getName() {
		System.out.println("---------getName-------");
		return name;
	}

	public void setName(String name) {
		this.name = Optional.ofNullable(name).filter(User::isNameValid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid username."));
	}
	public static Boolean isNameValid(String name){
		return true;
	}
}
