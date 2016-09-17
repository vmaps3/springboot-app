<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<title>My JSP 'updateUser.jsp' starting page</title>
	</head>

	<body>
		<form action="<%=path %>/sys/user/update.do" method="POST">
			<input type="hidden" name="id" value="${user.id }">
			<table>
				<tr>
					<td>
						username: 
					</td>
					<td>
						<input type="text" name="username" value="${user.username }">
					</td>
				</tr>
				<tr>
					<td>
						password:
					</td>
					<td>
						<input type="text" name="password" value="${user.password }">
					</td>
				</tr>
				<tr>
					<td>role:</td>
					<td>
					
					
					
						<select name="roleId" multiple=”multiple”>
							<c:forEach items="${list}" var="userRole">
								
								<c:choose>
										<c:when test="${userRole.selected == true}">
											<option value ="${userRole.id }" selected="${userRole.selected}">${userRole.name }</option>
										</c:when>  
										<c:otherwise>  
											<option value ="${userRole.id }" >${userRole.name }</option>
										</c:otherwise>
									</c:choose>
						  	</c:forEach>
						</select>
						
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Update">
					</td>
					<td>
						<input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
