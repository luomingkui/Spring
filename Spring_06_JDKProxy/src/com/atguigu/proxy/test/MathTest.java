package com.atguigu.proxy.test;


import com.atguigu.proxy.inter.EazyImpl;
import com.atguigu.proxy.inter.MathCalculator;
import com.atguigu.proxy.jdk.ProxyProvider;

public class MathTest {
	
	public static void main(String[] args) {
		
		/*//MathCalculator calculator = new EazyImpl();
		MathCalculator calculator = new LogImpl();
		calculator.add(10, 5);
		calculator.sub(10, 5);
		calculator.mul(10, 5);
		calculator.div(10, 5);*/
		
		
		//JDK动态代理执行过程
		//一：创建目标对象
		MathCalculator calculator = new EazyImpl();
		
		MathCalculator proxyObject = (MathCalculator)new ProxyProvider(calculator).getProxyObject();
		proxyObject.add(10, 5);
		proxyObject.sub(10, 5);
		proxyObject.mul(10, 5);
		proxyObject.div(10, 5);
		
		
	}

}
