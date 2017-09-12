package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.action.OrderAction;
import com.atguigu.spring.action.UserAction;

public class TestGenericInjection {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	
	@Test
	public void test() {
		
		UserAction userAction = ioc.getBean(UserAction.class);
		userAction.saveUser();
		
		System.out.println("--------------------");
		
		OrderAction orderAction = ioc.getBean(OrderAction.class);
		orderAction.saveOrder();
		
	}

}
