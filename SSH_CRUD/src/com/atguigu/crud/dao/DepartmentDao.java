package com.atguigu.crud.dao;

import java.util.List;

import com.atguigu.crud.entity.Department;

public interface DepartmentDao {

	List<Department> queryAll() throws Exception ;
	
}
