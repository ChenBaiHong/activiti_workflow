<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <title>工作流管理</title>
    <meta charset="utf8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="html/assets/global/plugins/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="html/assets/global/plugins/bootstrap/css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="html/baiHoo/css/templatemo-style.css" />
    <link rel="stylesheet" href="html/baiHoo/css/styles.css" />
    <style>
    body {
		font-family:"黑体";
    	font-size:16px;
		background: url(html/img/bg/4.jpg);
		background-attachment: fixed;
		background-size: cover;
		-webkit-background-clip: border-box;
	}
	.page {
	    background: rgba(225,225,225,0.7);
	}
	#in-nav {
	    background-color: transparent;
	}
    .panel {
        margin: 11px 20px;
    }
    </style>
    <script src="html/assets/jquery-2.1.0.min.js"></script>
  </head>
  <body>
  	<!-- 页面初始化加载启动动画 -->
  	<div id="loader-wrapper">
         <div id="loader"></div>
     </div>
    <!-- //页面初始化加载启动动画 -->
    <div id="in-nav">
      <div class="container" style="min-height: auto;">
        <div class="row">
          <div class="span12">
            <ul class="pull-right">
              <li>欢迎管理员 [ ${session['userModel'].name}]</li>
              <li><a href="user_logout.action"><i class="icon-off"></i> 退出登录</a></li>
            </ul>
           	<a id="logo" href="index.html">
           	   <div class="logo" style="position:absolute;margin-left:-75px;">
				<div style="width:80px;">
					<a href="index.html" style="display:inline-block;width:inherit;">
						<img src="html/icon/logo1.png" alt="" style="width:inherit;"/>
					</a>
				</div>
			  </div>
              <h4>
              	工作流系统<strong>管理</strong>
              </h4>
			</a>
          </div>
        </div>
      </div>
    </div>
    <div id="in-sub-nav">
      <div class="container">
        <div class="row">
          <div class="span12 mygGuide">
            <ul>
              <li><a href="user_defaultPage.action"  target="main" class="active"><i class="batch home"></i><br />首页</a></li>
              <li><a href="processDefinition_list.action" target="main" ><i class="batch stream"></i><br />审批流程管理</a></li>
              <li><a href="template_list.action" target="main" ><i class="batch plane"></i><br />表单模板管理</a></li>
              <li><a href="application_appList.action" target="main" ><i class="batch calendar"></i><br />起草申请管理</a></li>
              <li><a href="processController_myTaskList.action" target="main"><i class="batch quill"></i><br />待我审批管理</a></li>
              <li><a href="application_myApplicationList.action" target="main" ><i class="batch forms"></i><br />我的申请查询</a></li>
              <li><a href="user_list.action" target="main"><i class="batch users"></i><br />查询管理员</a></li>
              <li><a href="user_input.action" target="main"><i class="batch settings"></i><br />管理员设置</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="page">
     <iframe src="user_defaultPage" id="main" name="main"  width="100%" height="100%" style="border:none;"allowtransparency="true"></iframe>
    </div>
    <footer>
      <div class="container">
        <div class="row" style="padding:20px;">
          <div class="span12" style="color:white;">
            <p class="pull-right">baiHoo activiti工作流练习</p>
            <p>&copy;2017 版权创作归baiHoo所有</p>
          </div>
        </div>
      </div>
    </footer>
   <%@include file="/WEB-INF/jsp/tools/mask.jsp"%>
    <!-- js文件引入 -->
    
    <script type="text/javascript">
        //<![页面动画加载[
        $(window).load(function() { // makes sure the whole site is loaded
            $('#loader').fadeOut(); // will first fade out the loading animation
                $('#loader-wrapper').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
            $('body').delay(350).css({'overflow-y':'visible'});
        
        	$(".mygGuide ul li a").click(function(){
        		$(this).parent().siblings().find("a").removeClass('active');
        		$(this).addClass('active')
        	});
        })
        //]]>
    </script>
  </body>
</html>