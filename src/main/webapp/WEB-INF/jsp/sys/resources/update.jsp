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
				window.location="${pageContext.request.contextPath}/sys/resources/toList.do";
			}
		</script>
	</head>

	<body>
		<form id="ff" action="${pageContext.request.contextPath}/sys/resources/update.do" method="POST">
			<input type="hidden" name="id" value="${resources.id }">
			<table>
				<tr>
					<td>
						pid: 
					</td>
					<td>
					
					
					
					
						<select name="pid"  class="easyui-combobox">
							<c:forEach items="${list}" var="pId">
								
								<c:choose>
										<c:when test="${pId.selected == true}">
											<option value ="${pId.id }" selected="${pId.selected}">${pId.name }</option>
										</c:when>  
										<c:otherwise>  
											<option value ="${pId.id }" >${pId.name }</option>
										</c:otherwise>
									</c:choose>
						  	</c:forEach>
						</select>
						
					</td>
				</tr>
				<tr>
					<td>
						name: 
					</td>
					<td>
						<input type="text" name="name" value="${resources.name }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>
						url: 
					</td>
					<td>
						<input type="text" name="url" value="${resources.url }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>
						type: 
					</td>
					<td>
						<input type="text" name="type" value="${resources.type }" class="easyui-textbox">
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
