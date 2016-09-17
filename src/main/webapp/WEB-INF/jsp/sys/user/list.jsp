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
  	<a href="<%=path %>/sys/user/toAdd.do">Add User</a><br/>
	<table border="1" width="70%">
   		<tr>
   			<td>Id</td>
   			<td>UserName</td>
   			<td>PassWord</td>
   			
   			<td>Delete</td>
   			<td>Update</td>
   		</tr>
   		<c:forEach items="${list}" var="user">
   		<tr>
   			<td>${user.id }</td>
   			<td>${user.username }</td>
   			<td>${user.password }</td>
   			<td><a href="<%=path %>/sys/user/delete.do?id=${user.id }">Delete</a></td>
   			<td><a href="<%=path %>/sys/user/toUpdate.do?id=${user.id }">Update</a></td>
   		</tr>
   		</c:forEach>
   </table>
   
</body>
</html>