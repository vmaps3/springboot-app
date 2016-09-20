<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title></title>
	<script type="text/javascript">
		function addTab(title, url){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
	</script>
  </head>
  
 
    
   
  <body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:70px;">
    	 <h1>娱乐管理系统</h1>
    </div>
    
   
    <div data-options="region:'west',title:'West',split:true" style="width:200px;">
    	<c:forEach items="${resourceList}" var="resource">
		<a href="#" class="easyui-linkbutton" onclick="addTab('	${resource.name }','${pageContext.request.contextPath}${resource.url }')">	${resource.name }</a><br>
   	
   		
   		</c:forEach>
		<ul class="easyui-tree">
			<li>
				<span>My Documents</span>
				<ul>
					<li data-options="state:'closed'">
						<span>Photos</span>
						<ul>
							<li>
								<span>Friend</span>
							</li>
							<li>
								<span>Wife</span>
							</li>
							<li>
								<span>Company</span>
							</li>
						</ul>
					</li>
					<li data-options="state:'closed'">
						<span>Program Files</span>
						<ul>
							<li>Intel</li>
							<li>Java</li>
							<li>Microsoft Office</li>
							<li>Games</li>
						</ul>
					</li>
					<li>index.html</li>
					<li>about.html</li>
					<li>welcome.html</li>
				</ul>
			</li>
		</ul>
	
    
    </div>
    <div id="tt"   class="easyui-tabs" data-options="region:'center'" style="padding:5px;background:#eee;">
    	
	
    </div>
</body>
</html>
