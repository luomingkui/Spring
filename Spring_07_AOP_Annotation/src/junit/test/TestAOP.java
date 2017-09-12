package junit.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.atguigu.spring.aop.bean.EazyImpl;
import com.atguigu.spring.aop.bean.MathCalculator;

public class TestAOP {
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	@Test
	public void testAOP(){
		MathCalculator proxyObject = (MathCalculator)ioc.getBean(MathCalculator.class);
		//class com.sun.proxy.$Proxy8
		System.out.println(proxyObject.getClass());
		//调用代理对象  ->  调用处理器 -> 调用切面中的通知方法   -> 目标对象中方法
		proxyObject.add(10, 5);
		
	}
	
	@Test
	public void testAOP2(){
		EazyImpl proxyObject = (EazyImpl)ioc.getBean(EazyImpl.class);
		//class com.atguigu.spring.aop.bean.EazyImpl$$EnhancerByCGLIB$$297e0270
		System.out.println(proxyObject.getClass());
		//调用代理对象  ->  调用处理器 -> 调用切面中的通知方法   -> 目标对象中方法
		proxyObject.add(10, 5);
		System.out.println("---------------");
		//proxyObject.div(10, 0);
	}
}
