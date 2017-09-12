package com.atguigu.spring.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.spring.bean.Order;
import com.atguigu.spring.service.BaseService;

@Controller
@Scope("prototype")
public class OrderAction extends BaseAction<Order> {

	/*@Autowired
	private BaseService orderService ;*/
	
	public void saveOrder(){
		
		System.out.println("saveOrder...");
		
		service.save();
		
	}
	
}
