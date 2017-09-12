package com.atguigu.spring.bean;

public class User {
	
	private String name ;

	public User() {
		System.out.println("User Constructor...");
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
