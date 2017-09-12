package com.atguigu.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 工具类：用于生成JDK动态代理对象
 */
public class ProxyProvider {

	private Object targetObject ;//目标对象
	
	public ProxyProvider(Object targetObject){
		this.targetObject = targetObject ;		
	}
	
	public Object getProxyObject(){
				
		//①用于加载类到JVM中，用于加载内存中动态生成代理类
		ClassLoader classLoader = targetObject.getClass().getClassLoader() ;
		
		//②传递目标类的实现接口类型，代理类和目标类实现共同的接口
		Class[] interfaces = targetObject.getClass().getInterfaces();
		
		//③调用处理器：当客户端调用代理对象时，代理对象会执行调用处理器来完成功能扩展任务。
		InvocationHandler h = new InvocationHandler(){

			/**
			 * 1.代理对象
			 * 2.方法对象
			 * 3.方法的参数
			 */
			@Override
			public Object invoke(Object proxyObject, Method method, Object[] args) throws Throwable {
				
				System.out.println(targetObject.getClass().getName() + " - "+method.getName() + " - 开始执行了 : " + Arrays.asList(args));
				
				Object result = method.invoke(targetObject, args);
				
				System.out.println(targetObject.getClass().getName() + " - "+method.getName() + " - 执行结束了 : result = " + result);
				
				return result; //调用处理器返回结果就是目标对象方法的返回结果。一般不需要修改。
			}
			
		};
		
		Object proxyObject = Proxy.newProxyInstance(classLoader, interfaces, h);
		
		return proxyObject ;
	}
	
}
