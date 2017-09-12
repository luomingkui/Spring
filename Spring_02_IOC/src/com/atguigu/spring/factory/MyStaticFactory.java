package com.atguigu.spring.factory;

import java.util.HashMap;
import java.util.Map;

import com.atguigu.spring.bean.Book;

/**
 * 静态工厂方法提供Book对象。
 */
public class MyStaticFactory {
	
	private static Map<Integer,Book> map ;
	
	public MyStaticFactory(){
		System.out.println("=========MyStaticFactory======");
	}
	
	static {
		
		map = new HashMap<Integer,Book>();
		
		map.put(101, new Book("java",101.0));
		map.put(102, new Book("oracle",102.0));
		map.put(103, new Book("Web",103.0));
		
	}
	
	public static Book getBookFromStaticFactory(Integer key){
		return map.get(key);
	}
	
}
