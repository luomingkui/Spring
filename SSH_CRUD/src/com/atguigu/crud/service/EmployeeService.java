package com.atguigu.crud.service;

import java.util.List;

import com.atguigu.crud.entity.Employee;

public interface EmployeeService {
	
	List<Employee> queryAll() throws Exception ;
	
	void save(Employee emp) throws Exception ;
	
	Employee get(Integer empId) throws Exception ;
	
	void update(Employee emp) throws Exception ;
	
	void delete(Integer empId) throws Exception ;

}
