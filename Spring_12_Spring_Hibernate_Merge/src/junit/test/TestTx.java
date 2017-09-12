package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.sh.service.BookShopService;

public class TestTx {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	
	BookShopService bookShopService = (BookShopService)ioc.getBean("bookShopService");

	@Test
	public void testPurchase(){
		
		//Spring框架管理事务：
		//在业务层增加事务时，才会打开session,并且与当前线程进行绑定。DAO才可以通过getCurrentSession()获取session对象。
		//如果不给业务层增加事务，那么，框架就不会打开session,也不会将session与当前线程绑定，DAO就无法获取session ,就会报以下异常。
		//org.hibernate.HibernateException: No Session found for current thread		
		bookShopService.purchase("Tom", "ISBN-001");
		
	}
	
}
