package com.guo.mytest;

import java.util.Optional;

/**
 * 
 * @author Administrator
 * @date 2017/12/07
 */
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
