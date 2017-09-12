package com.atguigu.spring.component;

//开发原则三：接口隔离原则。接口功能性尽量单一。
public interface UserService {
	public void saveUser();
	
	//接口被污染了
	//当前接口的子孙类都必须实现，虽然我们用不到。
	//public void saveOrder();
}
