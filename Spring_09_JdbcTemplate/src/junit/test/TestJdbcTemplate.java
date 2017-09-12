package junit.test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.atguigu.spring.bean.Employee;

public class TestJdbcTemplate {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
	
	JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
	
	NamedParameterJdbcTemplate namedTemplate = (NamedParameterJdbcTemplate)ioc.getBean("namedTemplate");
	
	//实验1：测试数据源
	@Test
	public void testDataSource() throws SQLException {
		DataSource ds = ioc.getBean(DataSource.class);
		Connection con = ds.getConnection();
		System.out.println(con);
		con.close(); //归回
	}
	
	//实验2：将emp_id=5的记录的salary字段更新为1300.00
	@Test
	public void test02(){
		String sql = "UPDATE employee SET salary=1300.0 WHERE emp_id=?";
		jdbcTemplate.update(sql, 5);
	}
	
	//实验3：批量插入
	@Test
	public void test03(){
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
		
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"a",1000.0});
		batchArgs.add(new Object[]{"b",2000.0});
		batchArgs.add(new Object[]{"c",3000.0});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	
	// 实验4：查询emp_id=5的数据库记录，封装为一个Java对象返回
	@Test
	public void test04(){
		String sql = "SELECT emp_id AS empId ,emp_name AS empName, salary AS salary FROM employee WHERE emp_id = ?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class) ;
		
		Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, 5);
		
		System.out.println(emp);
	}
	// 实验5：查询salary>4000的数据库记录，封装为List集合返回
	@Test
	public void test05(){
	
		String sql = "SELECT emp_id AS empId ,emp_name AS empName, salary AS salary FROM employee WHERE salary > ?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class) ;
		
		List<Employee> empList = jdbcTemplate.query(sql, rowMapper, 4000.0);
		
		for (Employee employee : empList) {
			System.out.println(employee);
		}
	}
	
	// 实验6：查询最大salary
	@Test
	public void test06(){
		String sql = "SELECT max(salary) FROM employee";
		double salary = jdbcTemplate.queryForObject(sql, Double.class);
		System.out.println(salary);
	}
	
	
	// 实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
	@Test
	public void test07(){
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(:a,:salary)";
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("a", "abc");
		paramMap.put("salary", 2000.0);
		
		namedTemplate.update(sql, paramMap);
	}
	
	
	
	// 实验8：重复实验7，以SqlParameterSource形式传入参数值
	@Test
	public void test08(){
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(:empName,:salary)";
		//具名参数名称应该与实体对象的属性名称一致。
		Employee emp = new Employee();
		emp.setEmpName("zhangsan");
		emp.setSalary(30000.0);
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(emp);
		
		namedTemplate.update(sql, paramSource);
	}
	

}
