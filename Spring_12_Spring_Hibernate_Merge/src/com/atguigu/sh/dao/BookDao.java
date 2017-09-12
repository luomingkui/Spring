package com.atguigu.sh.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	// [1]根据isbn的值查询书的价格
	public int getBookPriceByISBN(String isbn) {
		String hql = "select b.price from Book b where b.isbn = ?";
		Integer price = (Integer) sessionFactory.getCurrentSession()
				.createQuery(hql).setParameter(0, isbn).uniqueResult();
		return price;
	}

	// [2]根据isbn的值减少书的库存，假设每次都只买1本书
	public void updateStockByISBN(String isbn) {
		String hql = "update Book b set b.stock = b.stock -1 where b.isbn = ?";
		sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, isbn).executeUpdate();
	}
}
