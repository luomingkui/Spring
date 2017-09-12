package com.atguigu.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TxAspect {

	@Before(value="execution(* com.atguigu.spring.aop.bean.EazyImpl.*(..))")
	public void startTx(){
		System.out.println("con.setAutoCommit(false);");
	}
	
	@AfterReturning(value="execution(* com.atguigu.spring.aop.bean.EazyImpl.*(..))")
	public void commitTx(){
		System.out.println("con.commit();");
	}
	
	@AfterThrowing(value="execution(* com.atguigu.spring.aop.bean.EazyImpl.*(..))")
	public void rollbackTx(){
		System.out.println("con.rollback();");
	}
	
	@After(value="execution(* com.atguigu.spring.aop.bean.EazyImpl.*(..))")
	public void closeCon(){
		System.out.println("con.close();");
	}
}
