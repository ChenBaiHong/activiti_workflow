<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <title>
   		流程进程图片显示
   </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	
				.taskInfo {
				    /* border: 2px solid #ea494a; */
				    top: 2%;
				    left: 25%;
				}
				.taskInfo {
				    position: absolute;
				    background-color: #14b8d4;
				    border-radius: 3px;
				    border: 1px solid #14b8d4;
				    margin: 0 auto;
				    padding: 10px 0 16px 0px;
				    font-size: 12px;
				    box-shadow: inset 0px 0px 10px rgba(255,255,255,0.5), 0px 0px 15px rgba(75,75,75,0.3);
				    text-align: left;
				    width: 178px;
				    color: white;
				}

				.span{
					margin:5px;
				}
				.span strong{
					padding: 5 0;
					display:inline-block;
				}
				input[type='text'] {
				    width: 100%;
				    border-radius: 2px;
				    border: none;
				    height: 22px;
				    background-color:white;
				}

	</style>
  </head>
  <body style="overflow:hidden">
		 <!--  1.获取到规则流程图 --> 
		<img style="width:100%;" src="application_viewProcessPNG?
								deploymentId=<s:property value='#deploymentId'/>
								&imageName=<s:property value='#imageName'/>">
		<div class="taskInfo">
			<div class="span">
				<strong>当前办理人:</strong>
				<input disabled="disabled" type="text" value="${assignee}">
			</div>
			<div class="span">
				<strong>办理的任务</strong>
				<input disabled="disabled" type="text" value="${name}">
			</div>
		</div>
		<!-- 2.根据当前活动的坐标，动态绘制DIV -->
		<%-- <div style="position: absolute;border:1px solid red;
							top:<s:property value="#acs.y-1"/>px;
							left: <s:property value="#acs.x-1"/>px;
							width: <s:property value="#acs.width"/>px;
							height:<s:property value="#acs.height"/>px;  "></div> --%>
  </body>
</html>
