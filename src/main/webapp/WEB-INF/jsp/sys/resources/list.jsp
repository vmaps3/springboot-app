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
  	<a href="<%=path %>/sys/resources/toAdd.do">Add User</a><br/>
	<table border="1" width="70%">
   		<tr>
   			<td>Id</td>
   			<td>pid</td>
   			<td>name</td>
   			<td>url</td>
   			
   			
   			<td>Delete</td>
   			<td>Update</td>
   		</tr>
   		<c:forEach items="${list}" var="resources">
   		<tr>
   			<td>${resources.id }</td>
   			<td>${resources.pid }</td>
   			<td>${resources.name }</td>
   			<td>${resources.url }</td>
   			<td><a href="<%=path %>/sys/resources/delete.do?id=${resources.id }">Delete</a></td>
   			<td><a href="<%=path %>/sys/resources/toUpdate.do?id=${resources.id }">Update</a></td>
   		</tr>
   		</c:forEach>
   </table>
   
</body>
</html>