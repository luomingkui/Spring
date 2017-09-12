package com.atguigu.spring.aop.bean;

//目标对象存在接口，那么，会产生JDK动态代理；
//目标对象没有接口，那么，会产生Cglib动态代理；
public interface MathCalculator {
	
	int add(int i,int j);
	int sub(int i,int j);
	int mul(int i, int j);
	int div(int i,int j); 

}
