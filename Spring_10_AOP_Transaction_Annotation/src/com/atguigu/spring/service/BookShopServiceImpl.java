package com.atguigu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.spring.dao.BookShopDao;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao ;
	//1.测试没有事务情况(正常运行)
	//2.测试没有事务情况(非正常运行：数据操作失败，有的语句执行成功了，有的语句失败，没有保证数据一致性和完整性。)
	//3.测试有事务情况 ：@Transactional
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.REPEATABLE_READ,
				rollbackFor={java.lang.Exception.class},
				timeout=3,readOnly=true)
	public void purchase(String isbn, String username) throws Exception {
		int price = bookShopDao.findBookPriceByIsbn("ISBN-001");
		int price2 = bookShopDao.findBookPriceByIsbn("ISBN-001");
	}
	@Transactional(propagation=Propagation.REQUIRED)	
	public void updatePrice(String isbn, int price) throws Exception {		
		bookShopDao.updateBookPrice(isbn,price);		
	}
}
