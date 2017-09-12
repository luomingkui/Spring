package com.atguigu.spring.service;


import com.atguigu.spring.dao.BookShopDao;


public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao ;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	 
	public void purchase(String isbn, String username) throws Exception {
	
		int price = bookShopDao.findBookPriceByIsbn("ISBN-001");
		
		//int price2 = bookShopDao.findBookPriceByIsbn("ISBN-001");
		
		/*Thread.sleep(5000);*/
		
		//int price2 = bookShopDao.findBookPriceByIsbn("ISBN-002");
		 
		bookShopDao.updateBookStock("ISBN-001");
		
		//int i = 1/0 ; //java.lang.ArithmeticException: / by zero
		//Class.forName("java.long.String"); //java.lang.ClassNotFoundException: java.long.String
		
		bookShopDao.updateAccount("Tom", price);
		/*
		try {
			updatePrice("ISBN-001",200); //演示转播行为
		} catch (Exception e) {
			e.printStackTrace();
			//自己处理异常，没有抛出，这样对当前方法事务没有影响，如果抛出，那么对当前方法事务有影响
		}*/
	}
 
	
	public void updatePrice(String isbn, int price) throws Exception {		
		bookShopDao.updateBookPrice(isbn,price);		
	}

}
