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
			
	       
	      		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="upd()">查看</a>
	            <span class="toolbar-item dialog-tool-separator"></span>
	            
	            
	            
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-options="disabled:false" onclick="upd2()">查看流程图</a>
	            <span class="toolbar-item dialog-tool-separator"></span>
	       
        </div> 
        
</div>
<table id="dg"></table> 
<div id="dlg"></div>  
<script type="text/javascript">
var dg;
$(function(){   
	dg=$('#dg').datagrid({    
	method: "get",
    url:'${pageContext.request.contextPath}/activiti/history/list.do', 
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
		{field:'id',title:'id',sortable:true,width:100,hidden:true},  
		{field:'processDefinitionName',title:'流程名称',sortable:true,width:100},  
		
		{field:'name',title:'任务名称',sortable:true,width:100},
		{field:'createTime',title:'时间',sortable:true,width:100},
       
    ]],
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    enableRowContextMenu: false,
    toolbar:'#tb'
});
});

//弹窗修改
function upd2(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;

	window.open('${pageContext.request.contextPath}/activiti/History/toViewImage.do?taskId='+row.id,"流程图","left=500,top=200,width=800,height=500,alwaysRaised:yes");
	
}

//弹窗修改
function upd(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	d=$("#dlg").dialog({   
	    title: '修改用户',    
	    width: 500,    
	    height: 500,    
	    href:'${pageContext.request.contextPath}/activiti/history/update.do?id='+row.id,
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