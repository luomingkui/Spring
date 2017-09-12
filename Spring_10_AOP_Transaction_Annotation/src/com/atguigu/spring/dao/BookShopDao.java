package com.atguigu.spring.dao;

public interface BookShopDao {
	
	// [1]根据isbn的值查询书的价格
	public abstract int findBookPriceByIsbn(String isbn) throws Exception;
	
	// [2]根据isbn的值减少书的库存，假设每次都只买1本书
	public abstract void updateBookStock(String isbn) throws Exception;
	
	// [3]根据用户名减少用户账户中的余额，减少的额度就是书的价格
	public abstract void updateAccount(String username,int bookPrice);

	
	
	public abstract void updateBookPrice(String isbn, int price);
	
}
