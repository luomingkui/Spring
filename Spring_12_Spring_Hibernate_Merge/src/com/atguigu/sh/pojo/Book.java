package com.atguigu.sh.pojo;

public class Book {
	private Integer bookId ;
	private String isbn ;
	private int price ;
	private int stock ;
	public Book() {
		super();
	}
	public Book(Integer bookId, String isbn, int price, int stock) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.price = price;
		this.stock = stock;
	}
	public Book(String isbn, int price, int stock) {
		super();
		this.isbn = isbn;
		this.price = price;
		this.stock = stock;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", price=" + price
				+ ", stock=" + stock + "]";
	}

}
