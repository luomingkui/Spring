package com.atguigu.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.atguigu.spring.bean.Book;

//声明工厂Bean来获取泛型的实例对象
public class MyFactoryBean implements FactoryBean<Book> {

	private String fileName = "hibernate.cfg.xml";
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public Book getObject() throws Exception {
		//SessionFactory sessionFactory = null ;
		System.out.println("fileName="+fileName);
		System.out.println("getObject() ...");
		return new Book(125,"Java编程思想","XXX");
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("getObjectType() ...");
		return Book.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("isSingleton() ...");
		//true : 表示单例管理Bean对象
		//false : 表示多例管理Bean对象
		return false;
	}

}
