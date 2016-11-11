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
				<input type="hidden" name="id" value="${id }" />
				<input name="days" type="text" value="${leave.days }"   class="easyui-validatebox" required="required"/>
				</td>
			</tr>
			<tr>
				<td>事由：</td>
				<td><input name="reason" type="text"  value="${leave.reason }" class="easyui-validatebox" required="required"/></td>
			</tr>
			<c:if test="${display=='yes'}">
				<tr>
					<td>批注：</td>
					<td><textarea name ="message" rows="" cols=""></textarea></td>
				</tr>
			</c:if>
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
	
	<div style="text-align:center;padding:5px">
		<c:forEach items="${buttonList}" varStatus="i" var="button" > 
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="approval('${button}  ')">${button}</a>
		</c:forEach>
	</div>
</div>

<script type="text/javascript">
function approval(value){
	var isValid = $(this).form('validate');
	if(isValid==true){
		$("#buttonValue").val(value);
		var str_data=$('#mainform').serialize() ;
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/workflow/leave/${action}",
			   data: str_data,
			   success: function(data){
					successTip(data,dg,d);
			   }
			});
	}
}


</script>
</body>
</html>