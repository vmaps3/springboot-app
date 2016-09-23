<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<html>
	<head>
		<title>My JSP 'updateUser.jsp' starting page</title>
		<script type="text/javascript">
			function submitForm(){
				$('#ff').submit()
			}
			function toList(){
				window.location="${pageContext.request.contextPath}/sys/user/toList.do";
			}
		</script>
	</head>

	<body>
		<form id="ff" action="${pageContext.request.contextPath}/sys/user/update.do" method="POST">
			<input type="hidden" name="id" value="${user.id }">
			<table>
				<tr>
					<td>
						username: 
					</td>
					<td>
						<input type="text" name="username" value="${user.username }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>
						password:
					</td>
					<td>
						<input type="text" name="password" value="${user.password }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>role:</td>
					<td>
					
					
					
						<select name="roleId" multiple="multiple" class="easyui-combobox">
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
				
			</table>
		</form>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="toList()">返回</a>
		</div>
	</body>
</html>
