package com.atguigu.crud.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.crud.entity.Department;

@Repository("departmentDao")
@SuppressWarnings("unchecked") //去除泛型警告
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory ;

	@Override
	public List<Department> queryAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("FROM Department").list();
	}

}
