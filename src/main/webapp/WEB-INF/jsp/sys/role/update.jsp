<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<html>
	<head>
		<title>My JSP 'updateUser.jsp' starting page</title>
		<script type="text/javascript">
			function submitForm(){
				if($("#ff").form('validate')==true){
					$('#ff').submit();
				}
			}
			function toList(){
				window.location="${pageContext.request.contextPath}/sys/role/toList.do";
			}
			$(function(){ 
				var s= new Array();
				<c:forEach items="${list}" var="roleResources">
				s. push('${roleResources.resourcesId}');
		  		</c:forEach>
		  		$("#cc").combotree('setValues',s);
				
			}); 
		</script>
	</head>

	<body>
		<form id="ff"  action="${pageContext.request.contextPath}/sys/role/update.do" method="POST">
			<input type="hidden" name="id" value="${role.id }">
			<table>
				<tr>
					<td>
						role: 
					</td>
					<td>
						<input type="text"   name="name" required="true" validType="length[1,25]" value="${role.name }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>resources:</td>
					<td>
						<input name="resourcesId" id="cc"   cascadeCheck ="false" required="true"  class="easyui-combotree" data-options="url:'${pageContext.request.contextPath}/sys/resources/list.do'" multiple >
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
