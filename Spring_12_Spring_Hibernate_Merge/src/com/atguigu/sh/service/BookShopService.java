package com.atguigu.sh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.sh.dao.AccountDao;
import com.atguigu.sh.dao.BookDao;

@Service
@Transactional
public class BookShopService {

	@Autowired
	private BookDao bookDao ;
	
	@Autowired
	private AccountDao accountDao ;
	
	//@Transactional
	public void purchase(String username,String isbn){
		
		int bookPriceByISBN = bookDao.getBookPriceByISBN(isbn);
		System.out.println("bookPriceByISBN="+bookPriceByISBN);
		
		bookDao.updateStockByISBN(isbn);
		
		accountDao.updateBalanceByUsername(username, bookPriceByISBN);
	}
	
}
