package com.atguigu.sh.pojo;

public class Account {
	private Integer accountId ;
	private String username ;
	private int balance ;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public Account(Integer accountId, String username, int balance) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.balance = balance;
	}
	public Account(String username, int balance) {
		super();
		this.username = username;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", username=" + username
				+ ", balance=" + balance + "]";
	}

}
