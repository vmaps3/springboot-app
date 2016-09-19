<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<html>
	<head>
		<title>My JSP 'addUser.jsp' starting page</title>
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/sys/user/add.do" method="POST">
			<table>
				<tr>
					<td>username:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td>role:</td>
					<td>
						<select name="roleId" multiple=”multiple”>
							<c:forEach items="${list}" var="role">
						  		<option value ="${role.id }">${role.name }</option>
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
