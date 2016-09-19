<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title></title>
	
  </head>
  
 
    
   
  <body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
    	  
    </div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;">
    	<a href="${pageContext.request.contextPath}/sys/user/list.do">User List</a><br>
   <a href="${pageContext.request.contextPath}/sys/role/list.do">role List</a><br>
   <a href="${pageContext.request.contextPath}/sys/resources/list.do">resources List</a>
    </div>
    <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
</body>
</html>
