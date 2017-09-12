package com.atguigu.spring.component;

import java.util.List;

public class UserServiceImpl implements UserService{

	private List<UserDaoImpl> userDao ;
	private String message ;
	
	public void setUserDao(List<UserDaoImpl> userDao) {
		this.userDao = userDao;
	}
	public void saveUser(){
		userDao.get(0).save();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<UserDaoImpl> getUserDao() {
		return userDao;
	}
	
}
