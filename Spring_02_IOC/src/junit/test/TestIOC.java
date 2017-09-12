package junit.test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.bean.Book;
import com.atguigu.spring.bean.BookShop;
import com.atguigu.spring.component.UserAction;

public class TestIOC {

	//ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml","beans2.xml");
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans*.xml");
	
	@Test
	public void testIOC() {
		//掌握6大开发原则：
		//UserAction bean = ioc.getBean(UserAction.class);
		UserAction bean = (UserAction) ioc.getBean("userAction");
		System.out.println(bean);
		
		UserAction bean2 = (UserAction) ioc.getBean("userAction");
		System.out.println(bean);
		
		System.out.println("bean == bean2? ===>>>>"+(bean == bean2));
		
		bean.saveUser();
		
		/*UserServiceImpl bean2 = ioc.getBean(UserServiceImpl.class);
		System.out.println(bean2);
		
		UserDaoImpl bean3 = ioc.getBean(UserDaoImpl.class);
		System.out.println(bean3);*/
	}

	@Test
	public void testIOC01(){
		//实验1：通过IOC容器创建对象，并为属性赋值★
		Book book = (Book)ioc.getBean("book");
		System.out.println(book);
		
		//实验2：根据bean的类型从IOC容器中获取bean的实例★
		//根据类型来查找，可能找到多个，那么，会报错。
		Book book2 = ioc.getBean(Book.class);
		//Book book2 = ioc.getBean("book",Book.class);
		System.out.println(book2);
	}
	
	@Test
	public void testIOC02(){
		/*
		 	实验3：通过构造器为bean的属性赋值
			实验4：通过index属性指定参数的位置
			实验5：通过类型不同区分重载的构造器
		 */
		Book book = (Book)ioc.getBean("book3");
		System.out.println(book);
		
		System.out.println("--------------------");
		
		book = (Book)ioc.getBean("book4");
		System.out.println(book);
	}
	
	@Test
	public void testIOC03(){
		//实验6：通过p名称空间为bean赋值
		Book book = (Book)ioc.getBean("book5");
		System.out.println(book);
		System.out.println("--------------------");
		//实验7：测试使用null值
		book = (Book)ioc.getBean("book6");
		System.out.println(book);
		
		//实验9：引用内部bean
		UserAction userAction = (UserAction)ioc.getBean("userAction2");
		System.out.println(userAction);
	}
	
	@Test
	public void testIOC04(){
		/*
			实验10：使用List类型的集合属性
			实验11：使用Map类型的集合属性
			实验12：使用prop子元素为Properties类型的属性赋值
		 */
		BookShop bookShop = (BookShop)ioc.getBean("bookShop");
		List<Book> bookList = bookShop.getBookList();
		for (Book book : bookList) {
			System.out.println(book);
		}
		
		System.out.println("--------------");
		
		Map<Integer, Book> bookMap = bookShop.getBookMap();
		Set<Entry<Integer, Book>> entrySet = bookMap.entrySet();
		for (Entry<Integer, Book> entry : entrySet) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		System.out.println("--------------");
		Properties properties = bookShop.getProperties();
		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			System.out.println(key + " - " + properties.getProperty((String)key));
		}
	}
	
	@Test
	public void testIOC05(){
		//实验13：通过util名称空间创建集合类型的bean
		List<Book> bookList = (List<Book>) ioc.getBean("bookList");
		for (Book book : bookList) {
			System.out.println(book);
		}
	}
	
	@Test
	public void testIOC06(){
		//实验14：给bean的级联属性赋值
		UserAction userAction3 = (UserAction)ioc.getBean("userAction3");
		System.out.println(userAction3);
	}
	
	@Test
	public void testIOC07(){
//		实验15：配置通过静态工厂方法创建的bean
//		实验16：配置通过实例工厂方法创建的bean
//		实验17：配置FactoryBean★
		Book book = (Book)ioc.getBean("getBookFromStaticFactory");	
		System.out.println(book);
		System.out.println("-----------------");
		Book book2 = (Book)ioc.getBean("getBookFromInstanceFactory");	
		System.out.println(book2);
		
		Book book8 = (Book)ioc.getBean("book8");
		
		Book book88 = (Book)ioc.getBean("book8");		
		
		System.out.println(book8 == book88);
	}
	
	@Test
	public void testIOC08(){
		//实验18：通过继承实现bean配置信息的重用
		//实验19：通过abstract属性创建一个模板bean
		Book book = (Book)ioc.getBean("book10");
		System.out.println(book);
		
		book = (Book)ioc.getBean("book12");
		System.out.println(book);
	}
	
	
	@Test
	public void testIOC09(){
		//实验20：bean之间的依赖
		//实验22：创建带有生命周期方法的bean
		AbstractApplicationContext aac = (AbstractApplicationContext)ioc;
		aac.close(); //关闭IOC容器时会调用Bean对象的销毁方法。
		
		//实验23：测试bean的后置处理器
	}
	
	@Test
	public void testIOC10() throws SQLException{
		//实验24：引用外部属性文件★
		DataSource ds = ioc.getBean(DataSource.class);
		Connection connection = ds.getConnection();
		System.out.println(connection);//com.mchange.v2.c3p0.impl.NewProxyConnection@71a3a752
		connection.close();
	}
	
}
