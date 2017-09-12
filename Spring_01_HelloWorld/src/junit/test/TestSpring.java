package junit.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pers.spring.bean.Student;

public class TestSpring {

	@Test
	public void testSpring() {
		
		//之前需要一个对象，自动动手，丰衣足食
		Student student = new Student();
		student.setStudentId(1);
		student.setStudetName("zhangsan");
		
		student.getStudentId();
		student.getStudetName();
		
		System.out.println(student);
		
		System.out.println("---------------------------");
		//有Spring的IOC容器，一切变得非常美好
		//第一个步骤：从类路径下，加载配置文件，构建IOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");		
		//第二个步骤：需要从IOC容器中获取一个Bean对象
		Student student1 = (Student)ioc.getBean("Student");

		//第三个步骤：只管使用就可以了
		System.out.println(student1);
		
		//Spring框架管理Bean对象方式：
		//默认情况下，是在构建IOC容器的时候已经创建好了Bean对象；
		//默认情况下, Bean对象是单例管理的。目的为了节省内存开销。
		//如果希望，每次getBean() 可以获取一个新的对象，需要多例创建对象。scope="prototype"

	}
}
