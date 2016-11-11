<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.jsp"%>
<html>
<head>
<title></title>

</head>
<body>
<div>
	<form id="mainform" action="${pageContext.request.contextPath}/workflow/deployment/${action}" method="post" enctype="multipart/form-data">
	<table  class="formTable">
		<tr>
			<td>流程名称：</td>
			<td>
			<input name="filename" type="text"   class="easyui-validatebox" required="required"/>
			</td>
		</tr>
		<tr>
			<td>流程文件：</td>
			<td><input name="file" type="file"    class="easyui-validatebox" required="required"/></td>
		</tr>
		
	</table>
	</form>
</div>
<script type="text/javascript">
$(function(){
	$('#mainform').form({    
	    onSubmit: function(){    
	    	var isValid = $(this).form('validate');
			return isValid;	// 返回false终止表单提交
	    },    
	    success:function(data){   
	    	successTip(data,dg,d);
	    }    
	}); 
});

</script>
</body>
</html>