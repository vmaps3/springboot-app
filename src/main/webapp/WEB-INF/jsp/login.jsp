<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title></title>
	<script type="text/javascript">
		function submitForm(){
			$('#ff').form('submit');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
  </head>
  
  <body>
 
   <div id="win" class="easyui-window" title="Login" style="width:300px;height:200px;">
	<form id="ff" style="padding:10px 20px 10px 40px;" action="${pageContext.request.contextPath}/login.do" method="post">
		<p>账号: <input type="text" name="username" value="wangsong"></p>
		<p>密码: <input type="password"  name="password" value="wangsong"></p>
		<div style="padding:5px;text-align:center;">
			
			<input type="submit" value="提交">
			<input type="reset" value="重置">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
		</div>
	</form>
</div>
  </body>
</html>
