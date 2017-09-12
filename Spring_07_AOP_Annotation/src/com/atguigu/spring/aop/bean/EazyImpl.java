package com.atguigu.spring.aop.bean;
import org.springframework.stereotype.Component;

/**
 * 目标类：目标对象
 * 	目标类中的方法：连接点
 *  通过切入点表达式匹配到的连接点，统称切入点
 */
@Component
public class EazyImpl {//implements MathCalculator{
	public int add(int i, int j) {
		int result = i + j;
		System.out.println("方法内部打印：result="+result);
		return result; 
	}

	public int sub(int i, int j) {
		int result = i - j;
		System.out.println("方法内部打印：result="+result);
		return result;
	}

	public int mul(int i, int j) {
		int result = i * j;
		System.out.println("方法内部打印：result="+result);
		return result;
	}

	public int div(int i, int j) {
		int result = i / j;
		System.out.println("方法内部打印：result="+result);
		return result;
	}
}
