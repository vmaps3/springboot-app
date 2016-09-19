<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<html>
	<head>
		<title>My JSP 'updateUser.jsp' starting page</title>
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/sys/role/update.do" method="POST">
			<input type="hidden" name="id" value="${role.id }">
			<table>
				<tr>
					<td>
						role: 
					</td>
					<td>
						<input type="text" name="name" value="${role.name }">
					</td>
				</tr>
				<tr>
					<td>resources:</td>
					<td>
					
					
					
						<select name="resourcesId" multiple=”multiple”>
							<c:forEach items="${list}" var="roleResources">
								
								<c:choose>
										<c:when test="${roleResources.selected == true}">
											<option value ="${roleResources.id }" selected="${roleResources.selected}">${roleResources.name }</option>
										</c:when>  
										<c:otherwise>  
											<option value ="${roleResources.id }" >${roleResources.name }</option>
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
