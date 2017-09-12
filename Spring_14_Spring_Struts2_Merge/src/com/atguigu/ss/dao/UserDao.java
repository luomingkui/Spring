package com.atguigu.ss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	/*@Autowired
	private SessionFactory sessionFactory ;*/

	public void save() {
		
		System.out.println("save by UserDao...");
		
	}

}
