<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>用户登录</title>
<meta charset="utf-8"/>
<link href="html/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="html/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="favicon.ico"/>
	<style type="text/css">
		body {
			color: #333333;
			font-family: "Open Sans",sans-serif;
			padding: 0px !important;
			margin: 0px !important;
			font-size: 13px;
			background: url(html/img/bg/2.jpg);
			background-attachment: fixed;
			background-size: cover;
			-webkit-background-clip: border-box;
		}
		.login .content {
			background: url(html/assets/global/img/bg-white-lock.png) repeat;
			width: 360px;
			margin: 0 auto;
			margin-bottom: 0px;
			padding: 30px;
			padding-top: 20px;
			padding-bottom: 15px;
			-webkit-border-radius: 7px;
			-moz-border-radius: 7px;
			-ms-border-radius: 7px;
			-o-border-radius: 7px;
			border-radius: 7px;
		}
		.login .content .login-form, .login .content .forget-form {
			padding: 0px;
			margin: 0px;
		}
		h3 {
			font-size: 23px;
		}
		.login .content h3 {
			color: #eee;
		}
		.login .content .form-title {
			font-weight: 300;
			margin-bottom: 25px;
		}
		.display-none, .display-hide {
			display: none;
		}
		.alert {
			border-width: 1px;
		}
		.alert-danger {
			background-color: #f2dede;
			border-color: #ebccd1;
			color: #a94442;
		}
		.close {
			display: inline-block;
			margin-top: 0px;
			margin-right: 0px;
			width: 9px;
			height: 9px;
			background-repeat: no-repeat !important;
			text-indent: -10000px;
			outline: none;
			background-image: url("html/assets/global/img/remove-icon-small.png") !important;
		}
		div, input, select, textarea, span, img, table, label, td, th, p, a, button, ul, code, pre, li {
			-webkit-border-radius: 0 !important;
			-moz-border-radius: 0 !important;
			border-radius: 0 !important;
		}
		div, input, select, textarea, span, img, table, label, td, th, p, a, button, ul, code, pre, li {
			-webkit-border-radius: 0 !important;
			-moz-border-radius: 0 !important;
			border-radius: 0 !important;
		}
		label {
			font-weight: 400;
			font-size: 14px;
		}
		.visible-ie8 {
			display: none;
		}
		.visible-ie9 {
			display: none;
		}
		.control-label {
			margin-top: 1px;
		}
		.input-icon {
			position: relative;
		}
		[class^='fa-'], [class^='glyphicon-'], [class^='icon-'], [class*=' fa-'], [class*=' glyphicon-'], [class*=' icon-'] {
			display: inline-block;
			margin-top: 1px;
			font-size: 14px;
			*margin-right: .3em: ;
			line-height: 14px;
			-webkit-font-smoothing: antialiased;
		}
		.input-icon > i {
			color: #ccc;
			display: block;
			position: absolute;
			margin: 11px 2px 4px 10px;
			z-index: 3;
			width: 16px;
			font-size: 16px;
			text-align: center;
		}
		.form-control {
			font-size: 14px;
			font-weight: normal;
			color: #333;
			background-color: #fff;
			border: 1px solid #e5e5e5;
			box-shadow: none;
			transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			-ms-border-radius: 4px;
			-o-border-radius: 4px;
			border-radius: 4px;
		}
		.input-icon > .form-control {
			padding-left: 33px;
		}
		.login .content .form-actions {
			background-color: transparent;
			clear: both;
			border: 0px;
			padding: 0px 30px 25px 30px;
			margin-left: -30px;
			margin-right: -30px;
		}
		.login .content .form-actions .checkbox {
			display: inline-block;
		}
		.login .content p, .login .content label {
			color: #fff;
		}
		.checker {
			margin-top: -2px !important;
			margin-right: 2px !important;
		}
		div.selector, div.checker, div.button, div.radio, div.uploader {
			display: -moz-inline-box;
			display: inline-block;
			*display: inline: ;
			zoom: 1;
			vertical-align: middle;
		}
		div.selector, div.selector *, div.radio, div.radio *, div.checker, div.checker *, div.uploader, div.uploader *, div.button, div.button * {
			margin: 0;
			padding: 0;
		}
		div.checker {
			position: relative;
		}
		div.checker, div.checker span, div.checker input {
			width: 19px;
			height: 19px;
		}
		div.radio, div.checker {
			margin-left: 3px;
		}
		div.selector, div.selector span, div.checker span, div.radio span, div.uploader, div.uploader span.action, div.button, div.button span {
			background-repeat: no-repeat;
			-webkit-font-smoothing: antialiased;
		}
		div.selector, div.selector *, div.radio, div.radio *, div.checker, div.checker *, div.uploader, div.uploader *, div.button, div.button * {
			margin: 0;
			padding: 0;
		}
		div.checker, div.checker span, div.checker input {
			width: 19px;
			height: 19px;
		}
		div.checker span {
			display: -moz-inline-box;
			display: inline-block;
			*display: inline: ;
			zoom: 1;
			text-align: center;
			background-position: 0 -260px;
		}
		div.selector, div.selector *, div.radio, div.radio *, div.checker, div.checker *, div.uploader, div.uploader *, div.button, div.button * {
			margin: 0;
			padding: 0;
		}
		div.checker input, input[type='search'], input[type='search']:active {
			-moz-appearance: none;
			-webkit-appearance: none;
		}
		div.checker, div.checker span, div.checker input {
			width: 19px;
			height: 19px;
		}
		.btn.dropdown-toggle, .btn-group .btn.dropdown-toggle, .btn:hover, :disabled.btn, [disabled].btn, .btn:focus, .btn:active, .btn.active {
			outline: none !important;
			background-image: none !important;
			filter: none;
			text-shadow: none;
			-webkit-box-shadow: none;
			-moz-box-shadow: none;
			box-shadow: none;
		}
		.blue.btn {
			color: #ffffff;
			background-color: #3598dc;
		}

		.blue.btn:hover, .blue.btn:focus, .blue.btn:active, .blue.btn.active {
			color: #ffffff;
			background-color: #2386ca;
		}
		[class^='m-icon-'] {
			display: inline-block;
			width: 14px;
			height: 14px;
			margin-top: 3px;
			line-height: 14px;
			vertical-align: top;
			background-image: url("html/assets/global/img/syncfusion-icons.png");
			background-position: 0 0;
			background-repeat: no-repeat;
		}
		.m-icon-white {
			background-image: url("html/assets/global/img/syncfusion-icons-white.png");
		}
		.m-icon-swapright {
			background-position: -27px -10px;
		}
		.btn > i {
			font-size: 14px;
		}
		.login .content h4 {
			color: #eee;
			font-size: 17px;
		}
		.social-icons {
			padding: 0;
			margin: 0;
		}
		.social-icons li {
			float: left;
			display: inline;
			list-style: none;
			margin-right: 5px;
			margin-bottom: 5px;
			text-indent: -9999px;
		}
		a {
			text-shadow: none;
			color: #5b9bd1;
		}
		.social-icons li > a {
			-webkit-border-radius: 2px;
			-moz-border-radius: 2px;
			-ms-border-radius: 2px;
			-o-border-radius: 2px;
			border-radius: 2px;
			width: 28px;
			height: 28px;
			display: block;
			background-position: 0 0;
			background-repeat: no-repeat;
			transition: all 0.3s ease-in-out;
			-o-transition: all 0.3s ease-in-out;
			-ms-transition: all 0.3s ease-in-out;
			-moz-transition: all 0.3s ease-in-out;
			-webkit-transition: all 0.3s ease-in-out;
		}
		.login .copyright {
			text-align:center;
			margin: 0 auto;
			padding: 10px;
			color: #eee;
			font-size: 13px;
		}

	</style>
</head>
<body class="login">
	<div class="logo">
		<div style="width:100px;margin:35 auto;">
			<a href="index.html" style="display:inline-block;width:inherit;">
				<img src="html/icon/logo1.png" alt="" style="width:inherit;"/>
			</a>
		</div>
	</div>
	<div class="menu-toggler sidebar-toggler"></div>
	<div class="content">
		<form class="login-form" action="javascript:;" method="post">
			<h3 class="form-title">登录你的账户</h3>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span>
				你的用户名和密码不正确 </span>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">登录用户</label>
				<div class="input-icon">
					<i class="fa fa-user"></i>
					<input class="form-control placeholder-no-fix" type="text" id="username" autocomplete="off" placeholder="登录用户" name="username"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">登录密码</label>
				<div class="input-icon">
					<i class="fa fa-lock"></i>
					<input class="form-control placeholder-no-fix" id="password" type="password" autocomplete="off" placeholder="登录密码" name="password"/>
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox">
				<input type="checkbox" name="remember" value="1" style="margin-left: 0px;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;记住我！</label>
				<!-- <input type="submit" id="submit" value="登录" class="btn blue pull-right"> -->
				<button  id="submit" class="btn blue pull-right">
				登录 <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
			<!-- <div class="login-options">
				<h4>其它登录</h4>
				<ul class="social-icons">
					<li>
						<a class="facebook" data-original-title="facebook" href="javascript:;">
						</a>
					</li>
					<li>
						<a class="twitter" data-original-title="Twitter" href="javascript:;">
						</a>
					</li>
					<li>
						<a class="googleplus" data-original-title="Goole Plus" href="javascript:;">
						</a>
					</li>
					<li>
						<a class="linkedin" data-original-title="Linkedin" href="javascript:;">
						</a>
					</li>
				</ul>
			</div> -->
		</form>
	</div>
	<div class="copyright">
		 2017 &copy; baiHoo -  工作流操作规范.
	</div>
	<script src="html/assets/jquery-2.1.0.min.js"></script>
	<script>
	$(document).ready(function(){
		$("#submit").click(function(){
	           	var userName = $("#username").val();
	           	var password = $("#password").val();
	           	if(userName.length==0 || password.length==0){
	           		return;
	           	}
           		var url = "user_ajaxLogin.action";
            	var args={"um.userName":userName,"um.password":password,"time":new Date()};
            	$.post(url, args , function(data){
            		if(data.jsonData=="yes"){
            			window.location.href="page_main.action";
            		}else{
            			$(".alert-danger").slideDown(600);
            			setTimeout(function(){
            				$(".alert-danger").slideUp(500);
            			},3000)
            		}
            	})
	      });
	});
</script>
</body>
</html>