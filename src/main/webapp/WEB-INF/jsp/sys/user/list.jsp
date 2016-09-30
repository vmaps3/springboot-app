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
		        	$.ajax({   
					     url:'${pageContext.request.contextPath}/sys/user/delete.do',   
					     type:'post',   
					     data:"id="+row.id,
					     success:function(data){   
					        if(data.msg==null){
					        	window.location="${pageContext.request.contextPath}/sys/user/toList.do";
					        }else{
					        	$.messager.alert('提示',data.msg);
					        }
					     }
					});
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
		window.location="${pageContext.request.contextPath}/sys/user/toUpdate.do?id="+row.id;
	}else{
		$.messager.alert('提示','请选择一条');
	}
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
               
                <th field="username" width="50">username</th>
                
            </tr>
        </thead>
    </table>
    <div id="toolbar">
    	<shiro:hasPermission name="/sys/user/add">
			<a href="${pageContext.request.contextPath}/sys/user/toAdd.do" class="easyui-linkbutton" iconCls="icon-add" plain="true" >新增</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="/sys/user/update">
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="upd()">编辑</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="/sys/user/delete">
        	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
        </shiro:hasPermission>
    </div>

</body>
</html>