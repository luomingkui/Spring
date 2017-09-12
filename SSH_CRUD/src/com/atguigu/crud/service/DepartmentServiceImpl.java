package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crud.dao.DepartmentDao;
import com.atguigu.crud.entity.Department;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao ;
	
	@Transactional
	@Override
	public List<Department> queryAll() throws Exception {		
		return departmentDao.queryAll();
	}

}
