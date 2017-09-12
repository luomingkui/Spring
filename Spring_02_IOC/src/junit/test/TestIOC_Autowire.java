package junit.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.component.UserService;

public class TestIOC_Autowire {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans4.xml");
	
	@Test
	public void testAutowire() {
		
		UserService userService = (UserService)ioc.getBean("userService2");
		System.out.println(userService);
		
	}

}
