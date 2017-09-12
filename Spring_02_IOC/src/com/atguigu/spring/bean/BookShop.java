package com.atguigu.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("all")
public class BookShop {

	private List<Book> bookList ;
	
	private Map<Integer,Book> bookMap ;	
	
	private Properties properties;

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Map<Integer, Book> getBookMap() {
		return bookMap;
	}

	public void setBookMap(Map<Integer, Book> bookMap) {
		this.bookMap = bookMap;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
}
