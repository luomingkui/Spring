package com.atguigu.spring.factory;

import java.util.HashMap;
import java.util.Map;

import com.atguigu.spring.bean.Book;

/**
 * 实例工厂方法提供Book对象。
 */
public class MyInstanceFactory {
	
	private Map<Integer,Book> map ;
	
	{
		
		map = new HashMap<Integer,Book>();
		
		map.put(101, new Book("java",101.0));
		map.put(102, new Book("oracle",102.0));
		map.put(103, new Book("Web",103.0));
		
	}
	
	public Book getBookFromInstanceFactory(Integer key){
		return map.get(key);
	}
	
}
