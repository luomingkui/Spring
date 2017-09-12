package com.atguigu.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.crud.entity.Employee;

@Repository("employeeDao")
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory ;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Employee> queryAll() throws Exception {		
		return getSession().createQuery("FROM Employee e LEFT JOIN FETCH e.dept").list();
	}

	@Override
	public void save(Employee emp) throws Exception {
		getSession().save(emp);
	}

	@Override
	public Employee get(Integer empId) throws Exception {
		return (Employee) getSession().get(Employee.class, empId);
	}

	@Override
	public void update(Employee emp) throws Exception {
		getSession().update(emp);
	}

	@Override
	public void delete(Employee emp) throws Exception {
		getSession().delete(emp);
	}

}
