<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<title>My JSP 'addUser.jsp' starting page</title>
	</head>

	<body>
		<form action="<%=path %>/sys/role/add.do" method="POST">
			<table>
				<tr>
					<td>role:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>resources:</td>
					<td>
						<select name="resourcesId" multiple=”multiple”>
							<c:forEach items="${list}" var="resources">
						  		<option value ="${resources.id }">${resources.name }</option>
						  	</c:forEach>
						  
						</select>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" value="Save">
					</td>
					<td>
						<input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
