package com.atguigu.spring.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.spring.bean.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	/*@Autowired
	private BaseService userService ;*/
	
	
	public void saveUser(){
		
		System.out.println("saveUser...");
		
		service.save();
		
	}
	
}
