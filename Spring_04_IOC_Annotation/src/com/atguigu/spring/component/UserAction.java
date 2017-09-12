package com.atguigu.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Controller(value="userAction")
@Component(value="userAction")
@Scope("prototype")
public class UserAction {

	//	实验35：使用@Autowired注解实现根据类型实现自动装配★
	//	实验36：如果资源类型的bean不止一个，默认根据@Autowired注解标记的成员变量名作为id查找bean，进行装配★
	//	实验37：如果根据成员变量名作为id还是找不到bean，可以使用@Qualifier注解明确指定目标bean的id★
	//	实验38：在方法的形参位置使用@Qualifier注解(了解)
	//	实验39：@Autowired注解的required属性指定某个属性允许不被设置
	
	
	/**
	 *  1.首先，根据byType进行装配，如果，查找到一个，那么直接装配
	 *  2.如果查找到多个相同类型的Bean对象，那么，会再根据byName进行查找。
	 *  	如果多个Bean对象中有Bean的id与属性名称相同，就直接装配
	 *  	如果多个Bean对象中没有与Bean的属性名称相同的id，那么，报错。
	 *  3.如果希望通过指定的名称id来装配Bean对象，可以借助于@Qualifier注解
	 *  4.当查找不到Bean对象，装配不成功，会报错时，希望装配不到Bean对象就不再装配Bean对象了。可以设置required=false
	 */
	@Autowired(required=false)
	@Qualifier(value="userService3")
	private UserService userService ;
	
	
	
}
