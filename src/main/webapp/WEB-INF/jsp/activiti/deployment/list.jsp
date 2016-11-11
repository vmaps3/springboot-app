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
			
	       	<shiro:hasPermission name="workflow:deployment:add">
	       		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add();">添加</a>
	       		<span class="toolbar-item dialog-tool-separator"></span>
	       	</shiro:hasPermission>
	       	<shiro:hasPermission name="workflow:deployment:delete">
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-options="disabled:false" onclick="del()">删除</a>
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
    url:'${pageContext.request.contextPath}/workflow/deployment/json', 
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
		{field:'deploymentTime',title:'deploymentTime',sortable:true,width:100},
        {field:'category',title:'category',sortable:true,width:100},    
        {field:'tenantId',title:'tenantId',sortable:true}
    ]],
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    enableRowContextMenu: false,
    toolbar:'#tb'
});
});

//弹窗增加
function add() {
	d=$("#dlg").dialog({   
	    title: '添加流程',    
	    width: 380,    
	    height: 250,    
	    href:'${pageContext.request.contextPath}/workflow/deployment/create',
	    maximizable:true,
	    modal:true,
	    buttons:[{
			text:'确认',
			handler:function(){
				$("#mainform").submit(); 
			}
		},{
			text:'取消',
			handler:function(){
					d.panel('close');
				}
		}]
	});
}

//删除
function del(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${pageContext.request.contextPath}/workflow/deployment/delete/"+row.id,
				success: function(data){
					successTip(data,dg);
				}
			});
		} 
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