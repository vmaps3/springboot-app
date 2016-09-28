<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
<script type="text/javascript">
function append(){
	var t = $('#tt');
	var node = t.tree('getSelected');
	window.location='${pageContext.request.contextPath}/sys/resources/toAdd.do?pid='+node.id
}
function removeit(){
	var node = $('#tt').tree('getSelected');
	
	 $.messager.confirm("确认", "确认删除吗？", function (r) {
	        if (r) {
	        	$('#tt').tree('remove', node.target);
	        	window.location="${pageContext.request.contextPath}/sys/resources/delete.do?id="+node.id;
	        }
	 });
}
function up(){
	var node = $('#tt').tree('getSelected');
	window.location='${pageContext.request.contextPath}/sys/resources/toUpdate.do?id='+node.id+'&pid='+node.pid;
	      
}


</script>
</head>
<body >
  	
   
	<ul id="tt" class="easyui-tree" data-options="
			url: '${pageContext.request.contextPath}/sys/resources/findResourceListByType.do',
			method: 'get',
			animate: true,
			onContextMenu: function(e,node){
				e.preventDefault();
				$(this).tree('select',node.target);
				$('#mm').menu('show',{
					left: e.pageX,
					top: e.pageY
				});
			}
		"></ul>
    
   
    <div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
		<div onclick="up()" data-options="iconCls:'icon-add'">更改</div>
		<div onclick="removeit()" data-options="iconCls:'icon-remove'">删除</div>	
	</div>
</body>
</html>