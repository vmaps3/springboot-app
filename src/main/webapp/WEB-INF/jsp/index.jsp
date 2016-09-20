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
		function convert(rows){
			function exists(rows, pid){
				for(var i=0; i<rows.length; i++){
					if (rows[i].id == pid) return true;
				}
				return false;
			}
			
			var nodes = [];
			// get the top level nodes
			for(var i=0; i<rows.length; i++){
				var row = rows[i];
				if (!exists(rows, row.pid)){
					nodes.push({
						id:row.id,
						text:row.name,
						url:row.url
						
					});
				}
			}
			
			var toDo = [];
			for(var i=0; i<nodes.length; i++){
				toDo.push(nodes[i]);
			}
			while(toDo.length){
				var node = toDo.shift();	// the parent node
				// get the children nodes
				for(var i=0; i<rows.length; i++){
					var row = rows[i];
					if (row.pid == node.id){
						var child = {id:row.id,text:row.name,url:row.url};
						if (node.children){
							node.children.push(child);
						} else {
							node.children = [child];
						}
						toDo.push(child);
					}
				}
			}
			return nodes;
		}
		
		$(function(){ 
			$('#tree').tree({
				url: '${pageContext.request.contextPath}/sys/resources/findResourceListByType.do',
				loadFilter: function(rows){
					return convert(rows);
				},
			 	onClick: function(node){
			       if($('#tree').tree('isLeaf',node.target)){//判断是否是叶子节点
			    	   addTab(node.text,'${pageContext.request.contextPath}'+node.url)
			       }
			    }
			});
		}); 
	</script>
  </head>
  
 
    
   
  <body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:70px;">
    	 <h1>娱乐管理系统</h1>
    </div>
    
   
    <div data-options="region:'west',title:'West',split:true" style="width:200px;">
    	<div id="tree"></div>
	
    
    </div>
    <div id="tt"   class="easyui-tabs" data-options="region:'center'" style="padding:5px;background:#eee;">
    	
	
    </div>
</body>
</html>
