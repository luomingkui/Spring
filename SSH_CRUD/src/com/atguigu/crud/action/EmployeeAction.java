package com.atguigu.crud.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.crud.entity.Department;
import com.atguigu.crud.entity.Employee;
import com.atguigu.crud.service.DepartmentService;
import com.atguigu.crud.service.EmployeeService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Controller("employeeAction")
public class EmployeeAction implements RequestAware,ModelDriven<Employee>,Preparable{

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService ;
	
	private Map<String, Object> request;
	
	private Employee employee;
	
	public String queryAll() throws Exception{
		
		List<Employee> empList = employeeService.queryAll();

		request.put("empList", empList);
		
		return "success";
	}

	//跳转添加页面，查询部门作为下拉列选
	public String toAdd() throws Exception{
		
		List<Department> deptList = departmentService.queryAll();
		
		request.put("deptList", deptList);
		
		return "add";
	}
	
	public void prepareAdd(){
		employee = new Employee();
	}
	
	public String add() throws Exception{
		employeeService.save(employee);
		return "list";
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request ;
	}

	@Override
	public void prepare() throws Exception {
		//已经被禁用
	}

	@Override
	public Employee getModel() {
		return employee;
	}
	
}
