package com.atguigu.spring.component;

public class UserServiceImpl2 implements UserService{

	private UserDaoImpl userDao ;
	
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	
	public void saveUser(){
		System.out.println(this.getClass().getName() + " - saveUser()....");
		userDao.save();		
	}
	
}
