package com.atguigu.spring.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.spring.service.BaseService;

public class BaseAction<T> {
	
	/*@Autowired
	protected BaseService orderService ;
	
	@Autowired
	protected BaseService userService ;*/
	
	
	@Autowired
	protected BaseService<T> service ; //既可以表示orderService，又可以表示userService
	
}
