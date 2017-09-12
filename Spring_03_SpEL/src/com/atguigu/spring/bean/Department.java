package com.atguigu.spring.bean;

public class Department {

	private String deptName ;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String message(String name){
		return "The Atguigu - " + name + "very good";
	}
	
}
