package com.atguigu.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;


public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate ;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int findBookPriceByIsbn(String isbn) throws Exception {
		String sql = "SELECT price FROM book WHERE isbn=?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class,isbn);
		return price;
	}

	@Override
	public void updateBookStock(String isbn) throws Exception {
		String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateAccount(String username, int price) {
		String sql = "UPDA@@@TE account SET balance=balance-? WHERE username=?";
		jdbcTemplate.update(sql, price,username);
	}

	@Override
	public void updateBookPrice(String isbn, int price) {
		String sql = "UPDATE book SET price=? WHERE isbn=?";
		jdbcTemplate.update(sql, price,isbn);		
	}

}
