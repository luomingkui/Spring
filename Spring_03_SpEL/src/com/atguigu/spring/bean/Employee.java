package com.atguigu.spring.bean;

public class Employee {

	private int id ;
	
	private String name ;
	
	private boolean married ;
	
	private Double salary ;
	
	private Department department ;
	
	private String deptName ;
	
	private double salayOfYear ;
	
	private double circle ;
	
	private String desc ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public double getSalayOfYear() {
		return salayOfYear;
	}

	public void setSalayOfYear(double salayOfYear) {
		this.salayOfYear = salayOfYear;
	}

	public double getCircle() {
		return circle;
	}

	public void setCircle(double circle) {
		this.circle = circle;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", married=" + married
				+ ", salary=" + salary + ", department=" + department
				+ ", deptName=" + deptName + ", salayOfYear=" + salayOfYear
				+ ", circle=" + circle + ", desc=" + desc + "]";
	}
	
	
	
}
