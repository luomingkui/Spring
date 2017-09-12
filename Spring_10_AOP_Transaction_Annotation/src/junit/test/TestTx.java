package junit.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.dao.BookShopDao;
import com.atguigu.spring.service.BookShopService;

public class TestTx {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	
	private BookShopDao bookShopDao = (BookShopDao)ioc.getBean("bookShopDao");
	
	private BookShopService bookShopService = (BookShopService) ioc.getBean("bookShopService");
	//private BookShopServiceImpl bookShopService = (BookShopServiceImpl)ioc.getBean("bookShopService");
	
	@Test
	public void testDataSource() throws SQLException {
		
		DataSource ds = ioc.getBean(DataSource.class);
		
		Connection connection = ds.getConnection();
		
		System.out.println(connection);
		
		connection.close();
		
	}
	
	@Test
	public void testDao01() throws Exception{
		int price = bookShopDao.findBookPriceByIsbn("ISBN-001");
		System.out.println(price);
	}
	
	@Test
	public void testDao02()throws Exception{
		bookShopDao.updateBookStock("ISBN-001");
	}	
	
	@Test
	public void testDao03()throws Exception{
		bookShopDao.updateAccount("Jerry", 100);
	}	
	
	//1.测试没有事务情况(正常运行)
	//2.测试没有事务情况(非正常运行：数据操作失败，有的语句执行成功了，有的语句失败，没有保证数据一致性和完整性。)
	//3.测试有事务情况
	@Test
	public void testPurchase() throws Exception{
		//class com.sun.proxy.$Proxy11
		//class com.atguigu.spring.service.BookShopServiceImpl$$EnhancerByCGLIB$$235ff7b0
		System.out.println(bookShopService.getClass());
		
		bookShopService.purchase("ISBN-001", "Tom");
	}
	
	
	@Test
	public void testUpdateBookPrice() throws Exception{
		bookShopService.updatePrice("ISBN-001", 200);
	}
	

}
