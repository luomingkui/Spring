package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	
	@Test
	public void test01() {
		Object userAction = ioc.getBean("userAction");
		System.out.println(userAction);
		
		userAction = ioc.getBean("userAction");
		System.out.println(userAction);
	}
	
	@Test
	public void test02() {
		Object us = ioc.getBean("userService");
		System.out.println(us);
		
		Object ud = ioc.getBean("userDao");
		System.out.println(ud);
	}

}
