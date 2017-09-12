package com.atguigu.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.ss.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao ;
	
	public void saveUser() {
		
		userDao.save();
		
	}

}
