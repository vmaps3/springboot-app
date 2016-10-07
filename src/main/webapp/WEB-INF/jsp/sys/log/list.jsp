<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
<script type="text/javascript">
	function DateFormatter(value,row,index){
 		var unixTimestamp = new Date(value);
 		return unixTimestamp.toLocaleString();
	}
</script>
</head>
<body>
  	
   <table id="dg"  class="easyui-datagrid"  fit="true" 
            url="${pageContext.request.contextPath}/sys/log/list.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" >
        <thead>
            <tr>
               
                <th field="url" width="50">url</th>
                <th field="parameter" width="50">parameter</th>
                <th field="remote_addr" width="50">remoteAddr</th>
                <th field="agent" width="50">agent</th>
                <th field="user_id" width="50">userId</th>
                <th field="begin_time" width="50" formatter="DateFormatter">begintime</th>
                <th field="end_time" width="50" formatter="DateFormatter">endtime</th>
             
            </tr>
        </thead>
    </table>
    <div id="toolbar">
    	
    </div>

</body>
</html>