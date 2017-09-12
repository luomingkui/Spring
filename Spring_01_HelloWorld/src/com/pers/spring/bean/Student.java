package com.pers.spring.bean;

public class Student {
	private Integer studentId;
	private String studetName;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudetName() {
		return studetName;
	}

	public void setStudetName(String studetName) {
		this.studetName = studetName;
	}

	public Student() {
		System.out.println("Student对象被IOC容器构建了。。。。");
	}

	public Student(Integer studentId, String studetName) {
		super();
		this.studentId = studentId;
		this.studetName = studetName;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studetName=" + studetName
				+ "]";
	}


}
