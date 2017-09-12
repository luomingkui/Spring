package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSessionFactory {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	
	@Test
	public void testSessionFactory() {
		//运行空方法，构建IOC容器，此时，SessionFactory被创建，根据hbm2ddl.auto=update来创建表
	}

}
