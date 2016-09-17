<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
</head>
<body>
  	<h3>UserList</h3>
  	<a href="<%=path %>/sys/role/toAdd.do">Add User</a><br/>
	<table border="1" width="70%">
   		<tr>
   			<td>Id</td>
   			<td>Name</td>
   			
   			
   			<td>Delete</td>
   			<td>Update</td>
   		</tr>
   		<c:forEach items="${list}" var="role">
   		<tr>
   			<td>${role.id }</td>
   			<td>${role.name }</td>
   			
   			<td><a href="<%=path %>/sys/role/delete.do?id=${role.id }">Delete</a></td>
   			<td><a href="<%=path %>/sys/role/toUpdate.do?id=${role.id }">Update</a></td>
   		</tr>
   		</c:forEach>
   </table>
   
</body>
</html>