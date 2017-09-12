package com.atguigu.spring.aop.aspect;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//切面（Aspect）：解决日志功能扩展。
@Component //声明当前类对象为系统的组件类对象
@Aspect //声明当前类为一个切面类

public class LogAspect {
	//重用切入点表达式
	@Pointcut(value="execution(* *.*(..))")
	public void pointcut(){}

	@Before("pointcut()")
	public void startLog(JoinPoint joinPoint){
		Signature signature = joinPoint.getSignature();
		String targetObjectMethod = signature.getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(targetObjectMethod + " - 方法开始执行了 - ages = " + Arrays.asList(args)); //横切关注点代码
	}
	
	//后置（最终）通知：
	//@After(value="execution(public int com.atguigu.spring.aop.bean.EazyImpl.*(int, int))")
	@After("pointcut()")
	public void endLog(JoinPoint joinPoint){
		Signature signature = joinPoint.getSignature();
		String targetObjectMethod = signature.getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(targetObjectMethod + " - 方法执行结束了 - ages = " + Arrays.asList(args));
	}
	
	//异常通知：
	//可以获取异常对象：throwing属性值，与异常通知修改的方法参数名称一致。
	//@AfterThrowing(value="execution(public int com.atguigu.spring.aop.bean.EazyImpl.*(int, int))",throwing="e")
	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void throwExceptionLog(JoinPoint joinPoint,Throwable e){
		Signature signature = joinPoint.getSignature();
		String targetObjectMethod = signature.getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(targetObjectMethod + " 方法执行出异常了 - 异常是："+e.getMessage());
	}

	//方法返回通知：
	//可以获取目标方法的返回结果：要求returning的值与通知方法参数的变量名称一致
	//@AfterReturning(value="execution(public int com.atguigu.spring.aop.bean.EazyImpl.*(int, int))",returning="result")
	@AfterReturning(pointcut="pointcut()",returning="result")
	public void methodReturningLog(JoinPoint joinPoint,Object result){
		Signature signature = joinPoint.getSignature();
		String targetObjectMethod = signature.getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(targetObjectMethod + " - 方法执行完成返回结果了 Args="+Arrays.asList(args)+"，result = " + result);
	}
	
	@Around(value="execution(public int com.atguigu.spring.aop.bean.EazyImpl.*(int, int))")
	public Object aroundLog(ProceedingJoinPoint pjp) {
		Signature signature = pjp.getSignature();
		String methodName = signature.getName();
		Object[] args = pjp.getArgs();
		Object result = null ;
		try {
			System.out.println("@Around - "+methodName + "方法开始执行了 - Args = " + Arrays.asList(args));
			result = pjp.proceed();//执行目标方法
			System.out.println("@Around - "+methodName + "方法执行完成了 - Args = " + Arrays.asList(args) + ",result=" + result);
		} catch (Throwable e) {
			System.out.println("@Around - "+methodName + "方法执行出现异常了 - " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e) ;
		} finally{
			System.out.println("@Around - "+methodName + "方法最终执行（释放资源）了 - Args = " + Arrays.asList(args) + ",result=" + result);
		}
		return result ;
	}

}
