<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
<script type="text/javascript">
//删除
function del(){
	var row = $("#dg").datagrid('getSelected');
	if(row!=null) {
		 $.messager.confirm("确认", "确认删除吗？", function (r) {
		        if (r) {
		        	window.location="${pageContext.request.contextPath}/sys/dict/delete.do?id="+row.id;
		        }
		 });
	}else{
		$.messager.alert('提示','请选择一条');
	}
}

//弹窗修改
function upd(){
	var row =  $("#dg").datagrid('getSelected');
	if(row!=null){
		window.location="${pageContext.request.contextPath}/sys/dict/toUpdate.do?id="+row.id;
	}else{
		$.messager.alert('提示','请选择一条');
	}
}

</script>
</head>
<body>
  	
   <table id="dg"  class="easyui-datagrid"  fit="true" 
            url="${pageContext.request.contextPath}/sys/dict/list.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" >
        <thead>
            <tr>
                <th field="id" width="50">id</th>
                <th field="code" width="50">code</th>
                <th field="name" width="50">name</th>
                <th field="type" width="50">type</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="${pageContext.request.contextPath}/sys/dict/toAdd.do" class="easyui-linkbutton" iconCls="icon-add" plain="true" >新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="upd()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
    </div>

</body>
</html>