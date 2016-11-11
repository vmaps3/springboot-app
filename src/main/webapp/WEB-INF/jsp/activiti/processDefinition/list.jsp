<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.jsp"%>
<html>
<head>
<title></title>
<script src="${pageContext.request.contextPath}/static/plugins/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

</head>
<body style="font-family: '微软雅黑'">
<div id="tb" style="padding:5px;height:auto">
        <div>
        	<form id="searchFrom" action="">
       	        <!--  
       	       <input type="text" name="filter_LIKES_label" class="easyui-validatebox" data-options="width:150,prompt: '标签'"/>
       	        <input type="text" name="filter_LIKES_value" class="easyui-validatebox" data-options="width:150,prompt: '值'"/>
       	      <input type="text" name="filter_LIKES_type" class="easyui-validatebox" data-options="width:150,prompt: '类型'"/>
		       --> 
		       <span class="toolbar-item dialog-tool-separator"></span>
		        <a href="javascript(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="cx()">查询</a>
			</form>
			<shiro:hasPermission name="workflow:processDefinition:view">
	       		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add();">查看流程图</a>
	       		<span class="toolbar-item dialog-tool-separator"></span>
	       	</shiro:hasPermission>
        </div> 
        
</div>
<table id="dg"></table> 
<div id="dlg"></div>  
<script type="text/javascript">
var dg;
$(function(){   
	dg=$('#dg').datagrid({    
	method: "get",
    url:'${pageContext.request.contextPath}/workflow/processDefinition/json', 
    fit : true,
	fitColumns : true,
	border : false,
	striped:true,
	idField : 'id',
	pagination:true,
	rownumbers:true,
	pageNumber:1,
	pageSize : 20,
	pageList : [ 10, 20, 30, 40, 50 ],
	singleSelect:true,
    columns:[[    
		{field:'id',title:'id',sortable:true,width:100},  
		{field:'name',title:'name',sortable:true,width:100},
		{field:'key',title:'key',sortable:true,width:100},
		{field:'deploymentId',title:'deploymentId',sortable:true,width:100},
		{field:'description',title:'description',sortable:true,width:100},
		{field:'diagramResourceName',title:'diagramResourceName',sortable:true,width:100},
		{field:'resourceName',title:'resourceName',sortable:true,width:100},
		{field:'tenantId',title:'tenantId',sortable:true,width:100},
		{field:'version',title:'version',sortable:true,width:100},
        {field:'category',title:'category',sortable:true,width:100},    
    ]],
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    enableRowContextMenu: false,
    toolbar:'#tb'
});
});

//弹窗增加
function add() {
	var row = dg.datagrid('getSelected');
	d=$("#dlg").dialog({   
	    title: '查看流程',    
	    width: 800,    
	    height: 500,    
	    href:'${pageContext.request.contextPath}/workflow/processDefinition/toViewImage?deploymentId='+row.deploymentId+"&diagramResourceName="+row.diagramResourceName,
	    maximizable:true,
	    modal:true,
	   
	});
}


//创建查询对象并查询
function cx(){
	var obj=$("#searchFrom").serializeObject();
	dg.datagrid('reload',obj); 
}

</script>
</body>
</html>