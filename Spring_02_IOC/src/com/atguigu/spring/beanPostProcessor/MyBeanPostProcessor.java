package com.atguigu.spring.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//后置处理器：
//可以在Bean的初始化方法前，后执行一些额外的处理
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object beanObject, String beanId)
			throws BeansException {
		
		System.out.println("postProcessAfterInitialization - beanObject="+beanObject);
		System.out.println("postProcessAfterInitialization - beanId="+beanId);
		
		return beanObject;
	}

	@Override
	public Object postProcessBeforeInitialization(Object beanObject, String beanId)
			throws BeansException {
		
		System.out.println("postProcessBeforeInitialization - beanObject="+beanObject);
		System.out.println("postProcessBeforeInitialization - beanId="+beanId);
		
		return beanObject;
	}

}
