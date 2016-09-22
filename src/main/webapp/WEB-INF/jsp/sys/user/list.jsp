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
	if(row==null) return;
	
	 $.messager.confirm("确认", "确认删除吗？", function (r) {
	        if (r) {
	        	window.location="${pageContext.request.contextPath}/sys/user/delete.do?id="+row.id;
	        }
	 });
}

//弹窗修改
function upd(){
	var row =  $("#dg").datagrid('getSelected');
	if(row==null) return;
	window.location="${pageContext.request.contextPath}/sys/user/toUpdate.do?id="+row.id;
}

</script>
</head>
<body>
  	
   <table id="dg"  class="easyui-datagrid"  fit="true" 
            url="${pageContext.request.contextPath}/sys/user/list.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" >
        <thead>
            <tr>
                <th field="id" width="50">id</th>
                <th field="username" width="50">username</th>
                <th field="password" width="50">password</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="${pageContext.request.contextPath}/sys/user/toAdd.do" class="easyui-linkbutton" iconCls="icon-add" plain="true" >新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="upd()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
    </div>

</body>
</html>