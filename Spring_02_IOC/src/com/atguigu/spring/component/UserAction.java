package com.atguigu.spring.component;

/**
 * 如果遵循了一，二，三，四的原则，那么就同时遵循了我们的另外两个原则：
 *	开闭原则：尽量不修改已有代码，将功能扩展增加到项目中。
 *	迪米特法则：高内聚，低耦合。
 */

//开发原则四：合成、聚合复用原则,表示通过关联关系带代替继承关系来对类中成员进行使用。
public class UserAction {

	//开发原则一：需要遵循依赖倒转原则:依赖于抽象，而不要依赖于具体。
	//推荐面向接口编程
	private UserService userService ;
	//private OrderService orderService ;
	
	//开发原则二：里氏代换原则。多态
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	public UserService getUserService() {
		return userService;
	}



	public void saveUser(){
		
		userService.saveUser();
		
		//不相干的方法也暴露给了调用者
		//userService.saveOrder();
	}
	
}
