<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<html>
	<head>
		<title>My JSP 'addUser.jsp' starting page</title>
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
		<form id="ff" action="${pageContext.request.contextPath}/sys/user/add.do" method="POST">
			<table>
				<tr>
					<td>username:</td>
					<td><input type="text" name="username" class="easyui-textbox"></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="text" name="password" class="easyui-textbox"></td>
				</tr>
				<tr>
					<td>role:</td>
					<td>
						<select name="roleId" multiple="multiple"  class="easyui-combobox">
							<c:forEach items="${list}" var="role">
						  		<option value ="${role.id }">${role.name }</option>
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
