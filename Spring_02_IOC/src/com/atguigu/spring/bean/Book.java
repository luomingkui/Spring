package com.atguigu.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
	private Integer bookId;
	private String title = "xxx";
	private String author;
	
	private double price ;
	
	/*@Autowired
	private UserService userService ;*/

	//初始化方法声明规则：必须是无参数的。
	//为Bean对象属性赋初始化值
	public void atguiguInit(){
		title = "abc";
		System.out.println("***********atguiguInit*****************");
	}
	
	//销毁方法声明规则：必须是无参数的。
	public void atguiguDestory(){
		title = null;
		System.out.println("***********atguiguDestory*****************");
	}
	
	
	public Book() {
		System.out.println("Book()..........");
	}

	public Book(Integer bookId, String title, String author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		System.out.println("Book(Integer bookId, String title, String author)");
	}

	public Book(double price,String title) {
		super();
		this.title = title;
		this.price = price;
		System.out.println("Book(double price,String title)");
	}

	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
		System.out.println("Book(String title, double price)");
	}

	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
		System.out.println("Book(String title, String author)");
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author="
				+ author + ", price=" + price + "]";
	}

	

}
