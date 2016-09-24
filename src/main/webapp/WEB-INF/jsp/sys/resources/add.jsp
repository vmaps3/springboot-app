<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<html>
	<head>
		<title>My JSP 'addUser.jsp' starting page</title>
		<script type="text/javascript">
			function submitForm(){
				$('#ff').submit();
			}
			function toList(){
				window.location="${pageContext.request.contextPath}/sys/resources/toList.do";
			}
			
		</script>
	</head>

	<body>
		<form id="ff" action="${pageContext.request.contextPath}/sys/resources/add.do" method="POST">
			<input type="hidden" name="pid" value="${pid}"/>
			<table>
				
				
				<tr>
					<td>name:</td>
					<td><input type="text" name="name" class="easyui-textbox"></td>
				</tr>
				<tr>
					<td>url:</td>
					<td><input type="text" name="url" class="easyui-textbox"></td>
				</tr>
				<tr>
					<td>type:</td>
					<td><input type="text" name="type" class="easyui-textbox"></td>
				</tr>
				
				
				
			
			</table>
		</form>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="toList()">返回</a>
		</div>
	</body>
</html>
