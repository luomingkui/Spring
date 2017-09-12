<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.atguigu.crud.entity.Employee"%>    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<s:if test="#request.empList == null || #request.empList.empty">
		没有查询到员工数据
	</s:if>
	<s:else>
		
		<center>
			<table border="1">
				<tr>
					<th>编号</th>
					<th>员工姓名</th>
					<th>部门名称</th>
					<th>更新</th>
					<th>删除</th>
				</tr>
				
				<s:iterator value="#request.empList" >
					<tr>
						<td><s:property value="empId"/></td>
						<td><s:property value="empName"/></td>
						<td><s:property value="dept.deptName"/></td>
						<td>更新</td>
						<td>删除</td>
					</tr>
				</s:iterator>
				
			</table>
				
				<a href="${pageContext.request.contextPath }/toAddEmployee.action">添加</a>
		</center>
		
	</s:else>
	

</body>
</html>