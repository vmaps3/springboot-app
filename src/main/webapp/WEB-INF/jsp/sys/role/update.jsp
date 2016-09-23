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
				window.location="${pageContext.request.contextPath}/sys/role/toList.do";
			}
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
						<input type="text" name="name" value="${role.name }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>resources:</td>
					<td>
					
					
					
						<select name="resourcesId" multiple="multiple" class="easyui-combobox">
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
				
			</table>
		</form>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="toList()">返回</a>
		</div>
	</body>
</html>
