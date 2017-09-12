package com.atguigu.spring.service;

public interface BookShopService {
	public abstract void purchase(String isbn,String username) throws Exception;
	
	public abstract void updatePrice(String isbn,int price) throws Exception ;
}
