package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpEL {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	
	@Test
	public void test() {
		// 实验26：[SpEL测试I]在SpEL中使用字面量
		// 实验27：[SpEL测试II]在SpEL中引用其他bean
		// 实验28：[SpEL测试III]在SpEL中引用其他bean的某个属性值
		// 实验29：[SpEL测试IV]在SpEL中调用非静态方法
		// 实验30：[SpEL测试V]在SpEL中调用静态方法
		// 实验31：[SpEL测试VI]在SpEL中使用运算符
		Object obj = ioc.getBean("emp");
		System.out.println(obj);
		
	}

}
