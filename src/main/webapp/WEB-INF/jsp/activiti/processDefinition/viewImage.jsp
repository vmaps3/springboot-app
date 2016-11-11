<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.jsp"%>
<html>
<head>
<title></title>

</head>
<body>
<div>
	<img src="${pageContext.request.contextPath}/activiti/processDefinition/viewImage.do?deploymentId=${deploymentId}&diagramResourceName=${diagramResourceName}" alt="" />
</div>
	<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="toList()">返回</a>
		</div>
	
<script type="text/javascript">
	function toList(){
		window.location="${pageContext.request.contextPath}/activiti/processDefinition/toList.do";
	}
</script>
</body>
</html>