<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title></title>
	
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/login.do" method="post">
  spring-app<br>
  	账号：<input type="text" name="username"><br>
   	密码：<input type="password" name="password"><br>
   	<input type="submit" name="提交">
   	<input type="reset" name="重置">
   </form>
   
  </body>
</html>
