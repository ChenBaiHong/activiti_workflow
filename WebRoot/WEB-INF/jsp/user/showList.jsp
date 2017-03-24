<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <title>DataGrid</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="html/assets/global/plugins/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="html/assets/global/plugins/easyui/themes/icon.css">
	<style type="text/css">
	.datagrid {
		margin: auto; margin-top: 10%;
	}
	</style>
	<!--引入Jquery主文件-->
	<script type="text/javascript" src="html/assets/global/plugins/easyui/jquery.min.js"></script>
	<!--引入JqueryEasyUI主文件-->
	<script type="text/javascript" src="html/assets/global/plugins/easyui/jquery.easyui.min.js"></script>
	<!--让easyUI支持中文-->
	<script type="text/javascript" src="html/assets/global/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
  	<script type="text/javascript">
  		var url;
	  function updateUser(){
	  	 var row=$("#dg").datagrid("getSelected");
		 if(row){
		 $("#dlg").dialog({closed:false});
			  $("#fm").form("load",row);
			  url="user_saveByEasyUI.action?um.uuid="+row.uuid;
		 }
	  }
	  function deleteUser(){
	  	 var row=$("#dg").datagrid("getSelected");
		 if(row){
		 	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
			    if (r){    
			        $.post('user_delete.action',{"um.uuid":row.uuid},function(data){
						//alert(data);
						if(data.result){
							$("#dg").datagrid("reload");
						}else{
							alert("error!");
						}
					},"json");    
			    }    
			}); 
		 }
	  }
	  function saveUser(){
	  	$('#fm').form('submit', {    
		    url:url,    
		    onSubmit: function(){  
			  //表单验证  
		    },    
		    success:function(data){    
		       var data=eval("("+data+")");
			   if(data.result=="true"){
			   	  $('#dlg').dialog({closed:true});
				  $("#dg").datagrid("reload");
			   }   
		    }    
		}); 
	  }
	</script>
  </head>
  <body>   
   
   <table id="dg" class="easyui-datagrid" style="width: 700px;height:350px;"   
        data-options="url:'user_ajaxList.action,fitColumns:true,singleSelect:true,pagination:true,toolbar:'#tb'">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'name',width:100">真实姓名</th>   
	            <th data-options="field:'userName',width:100">登录昵称</th> 
	            <th data-options="field:'email',width:100">联系邮箱</th>
				<th data-options="field:'tele',width:100">联系电话</th> 
	        </tr>   
	    </thead>   
   </table>  
   <div id="tb">
	 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="updateUser()"> 更新</a>
	 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="deleteUser()"> 删除</a>
   </div>
   <div id="dlg" class="easyui-dialog" style="width:300px;height:200px;background:gray;text-align:center;" data-options="buttons:'#btns',closed:true">
   	   <form id="fm" method="post">
   	   	   <center>学员信息</center>
   	   	   真实姓名:<input type="text" name="name"/><br/>
		   登录昵称:<input type="text" name="userName"/><br/>
		   联系邮箱:<input type="text" name="email"/><br/>
		   联系电话:<input type="text" name="tele"/><br/>
   	   </form>
   </div>
   <div id="btns">
   	 <a href="#" class="easyui-linkbutton" onclick="saveUser()">保存</a>
	 <a href="#" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog({closed:true})">取消</a>
   </div>
</body>  
</html>