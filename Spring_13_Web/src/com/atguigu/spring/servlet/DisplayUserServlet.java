package com.atguigu.spring.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.spring.bean.User;

/**
 * 从IOC容器中获取User对象，给客户端展示
 */
public class DisplayUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取IOC容器
		
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		
		System.out.println(ioc.getClass());
		
		//从IOC容器中获取User对象
		User user = (User)ioc.getBean("user");
		
		//展示User对象
		response.getWriter().println(user);
		response.getWriter().println("<br>");
		response.getWriter().println(user.getName());
		
	}

}
