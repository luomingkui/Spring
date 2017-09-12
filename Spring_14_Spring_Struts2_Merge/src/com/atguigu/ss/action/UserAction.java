package com.atguigu.ss.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.ss.service.UserService;


@Controller
@Scope("prototype")
public class UserAction {
	
	@Autowired
	private UserService userService ;
	
	public String execute(){
		
		userService.saveUser();
		
		return "success";
	}
	
}
