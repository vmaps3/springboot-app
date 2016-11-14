<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.jsp"%>
<html>
<head>
<title></title>

</head>
<body>
<div>
	<form id="mainform" action="" method="post" >
		<table  class="formTable">
			<tr>
				<td>天数：</td>
				<td>
						<input type="hidden" name="id" value="${leave.id }" />
					<input name="days" type="text" value="${leave.days}"   class="easyui-textbox"  required="required" />
				</td>
			</tr>
			<tr>
				<td>事由：</td>
				<td>
					<input name="reason" type="text"  value="${leave.reason }"  class="easyui-textbox"  required="required" />
				</td>
			</tr>
			<tr>
					<td>批注：</td>
					<td><textarea name ="message" rows="" cols=""></textarea></td>
				</tr>
			
		</table>
		<input  type="hidden"  id="buttonValue" name="buttonValue" />
	</form>
	<c:if test="${fn:length(commentList)!=0}">
	批注信息
		<table  class="formTable">
			<tr>
				<td>办理人</td>
				<td>审批信息</td>
				<td>审批时间</td>
			</tr>
			<c:forEach items="${commentList}" varStatus="i" var="comment" > 
				 <tr>
					<td>	${comment.userName}</td>
					<td>${comment.fullMessage} </td>
					<td>${comment.time} </td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="approval('同意')">同意</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="approval('不同意')">不同意</a>
	</div>
</div>

<script type="text/javascript">
	function approval(value){
		$("#buttonValue").val(value);
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/activiti/leave/examine.do",
			   data: $('#mainform').serializeArray(),
			   success: function(data){
					window.location="${pageContext.request.contextPath}/activiti/activiti/toList.do";
			   }
			});
	}


</script>
</body>
</html>