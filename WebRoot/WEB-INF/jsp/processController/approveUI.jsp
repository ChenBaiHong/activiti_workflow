<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
 	<title>工作流管理</title>
    <meta charset="utf8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="html/assets/global/plugins/easyForm/js/easyform/easyform.css">
    <style type="text/css">
	  html {
	    font-size: 16px;
	    font-family: "微软雅黑","黑体";
		}
        body {
            background-color: transparent;
            text-align: center;
        }
        input[type='text'], input[type='password'], input[type='email'] {
            box-shadow: inset 0px 2px 5px #eee;
            padding: 8px;
            border: 1px solid #D4D4D4;
            color: #333333;
            margin-top: 5px;
        }

        .form-div input[type='text'], .form-div input[type='password'], .form-div input[type='email'] {
            margin: 10px;
            line-height: 20px;
            font-size: 16px;
        }
        input[type='text']:focus, input[type='password']:focus, input[type='email']:focus {
            border: 1px solid #50afeb;
            outline: none;
        }


        input[type="button"], input[type="submit"],input[type="reset"],.return , .submit{
            padding: 7px 15px;
            background-color: #3c6db0;
            text-align: center;
            border-radius: 5px;
            overflow: hidden;
            min-width: 80px;
            border: none;
            color: #FFF;
            box-shadow: 1px 1px 1px rgba(75, 75, 75, 0.3);
        }
		input[type="button"], input[type="submit"],input[type="reset"],.return ,.submit{font-size:16px ; }

		input[type="button"]:hover, input[type="submit"]:hover,input[type="reset"]:hover,.return:hover .submit:hover{ background-color: #5a88c8;}

 		input[type="button"]:active, input[type="submit"]:active,input[type="reset"]:active,.return:active ,.submit:active {background-color: #5a88c8;}
		 .form-div {
		      background-color: rgba(255, 255, 255, 0.27);
		      border-radius: 10px;
		      border: 1px solid #aaa;
		      margin: 0 auto;
		      padding: 30px 0 20px 0px;
		      font-size: 12px;
		      box-shadow: inset 0px 0px 10px rgba(255,255,255,0.5), 0px 0px 15px rgba(75,75,75,0.3);
		      text-align: left;
		      width:1000px;
		}
		 .header {
		    margin: 25px 0;
		}
		        
		.link {
		    outline: none;
		    text-decoration: none;
		    position: relative;
		    font-size: 55px;
		    line-height: 90px;
		    color: #9e9ba4;
		    display: inline-block;
		}
		.title-ani {
		    text-transform: uppercase;
		    font-weight: 900;
		    overflow: hidden;
		    line-height: 90px;
		    color: #b2b0a9;
		}
		.title-ani::after {
		    content: "";
		    position: absolute;
		    height: 16px;
		    width: 100%;
		    top: 50%;
		    margin-top: -8px;
		    right: 0px;
		    background: #F9F9F9;
		    transform: translate3d(-100%, 0px, 0px);
		    transition: transform 0.4s;
		    transition-timing-function: cubic-bezier(0.7, 0, 0.3, 1);
		}
		.title-ani::before {
		    content: attr(data-letters);
		    position: absolute;
		    z-index: 2;
		    overflow: hidden;
		    color: #777;
		    white-space: nowrap;
		    width: 0%;
		    transition: width 0.4s 0.3s;
		}
		.title-ani:hover {
		    color: #b2b0a9;
		}
		.title-ani:hover::after {
		    transform: translate3d(100%, 0px, 0px);
		}
		.title-ani:hover::before {
		    width: 100%;
		}
		.form-div table{
			margin:auto;
			width:80%;
		}
		
		.buttons .button {
		    display: inline-block;
		    border-radius: 2px;
		    margin-left: 16.66%;
		    text-align: center;
		}

		.buttons .return{
		    display: inline-block;
		    border-radius: 2px;
		    text-align:center;
		   background-color:#eee;
		   vertical-align:top;
		}
		.form-div .step1 table {
		    margin: auto;
		    width: 50%;
		}
		.form-div .step1 table tr{
		    text-align:center;
		}
		
		.clear{
			clear:both;
		}	
		hr {
		    margin-top: 20px;
		    margin-bottom: 20px;
		    border: 0;
		    border-top: 1px solid #eee;
		}
		.decorate {
    		margin-top: 12%;
    		text-align: left;
		}		
		.note.note-success {
		    background-color: #eef7ea;
		    border-color: #c9e2b3;
		    color: #3c763d;
		}
		
		.note {
		    margin: 0 0 20px 0;
		    padding: 15px 30px 15px 15px;
		    border-left: 5px solid #eee;
		    -webkit-border-radius: 0 4px 4px 0;
		    -moz-border-radius: 0 4px 4px 0;
		    -ms-border-radius: 0 4px 4px 0;
		    -o-border-radius: 0 4px 4px 0;
		    border-radius: 0 4px 4px 0;
		}
		 /*****************************************************/
        /*****************************************************/
        /*****************************************************/
        /*****************************************************/
         .twt-feed {
        border-radius: 4px 4px 0 0;
        -webkit-border-radius: 4px 4px 0 0;
        color: #ffffff;
        padding: 10px;
        position: relative;
        text-align: center;
    }
    .twt-feed.blue-bg {
        background: #ea494a;
    }
    .twt-feed h1 {
        font-size: 22px;
        font-weight: 300;
        margin-bottom: 5px;
    }
    a, a:hover, a:focus {
        text-decoration: none;
        outline: none;
    }
    .twt-feed a {
        border: 8px solid #fff;
        border-radius: 50%;
        -webkit-border-radius: 50%;
        display: inline-block;
        margin-bottom: -55px;
    }
    .twt-feed a .img {
        height: 112px;
        width: 112px;
        border-radius: 50%;
        -webkit-border-radius: 50%;
        background:url(html/icon/logo1.png);
        background-size:cover;
    }
        .decorate {
    		margin-top: 12%;
    		text-align: left;
		}		
		.note.note-success {
		    background-color: #eef7ea;
		    border-color: #c9e2b3;
		    color: #3c763d;
		}
		
		.note {
		    margin: 0 0 20px 0;
		    padding: 15px 30px 15px 15px;
		    border-left: 5px solid #eee;
		    -webkit-border-radius: 0 4px 4px 0;
		    -moz-border-radius: 0 4px 4px 0;
		    -ms-border-radius: 0 4px 4px 0;
		    -o-border-radius: 0 4px 4px 0;
		    border-radius: 0 4px 4px 0;
		}
		.fileinput-button , .filedownload , .textTitle{
			color:white;
		 	padding: 5px;
		 	cursor:pointer;
    		border-radius: 3;
		    position: relative;
		    overflow: hidden;
		    background: #78CD51;
		    border-color: #78CD51;
		}
		.textTitle{
			background-color:#5a88c8;
		}
		.fileinput-button:hover, .fileinput-button:focus, .fileinput-button:active,
		.filedownload:hover, .filedownload:focus , .filedownload:active{
		    background-color: #6dbb4a;
		    border-color: #6dbb4a;
		    color: #ffffff;
		    text-decoration:underline;
		}
		input.inputFile{
			display:none;
		}
		textarea{
		    border-radius: 5;
		    border: none;
		    padding-left: 10px;
		}
    </style>
    <script src="html/assets/global/plugins/easyForm/js/jquery-2.1.0.min.js"></script>
    <script src="html/assets/global/plugins/easyForm/js/easyform/easyform.js"></script>
</head>
<body>
<div class="page">
	<div class="row" style="width: 45%;margin: auto;">
      <div class="col-lg-12">
          <section class="panel" style="background-color:transparent;">
              <div class="twt-feed blue-bg">
                  <h1>
                     ${session['userModel'].name}
                  </h1>
                  <p>
                      ${session['userModel'].email}
                  </p>
                  <a href="#">
                      <!-- <img alt="" src="img/profile-avatar.jpg"> -->
                      <div class="img"></div>
                  </a>
              </div>
          </section>
      </div>
  </div>
    <hr>
    <div class="form-div">
        <s:form id="reg-form" action="processController_approveHandle.action" method="post">
            <section class="step1" style="width:83%;margin:auto;">
            <s:hidden name="taskId"></s:hidden>
	    	<s:hidden name="applicationId"></s:hidden>
	    	<input type="hidden"  id="approval" name="approval" value="true"/>
            <table>
                <tr>
                    <td colspan="2">
                    	<div class="button filedownload">
		             		<a href="application_downloadAppDoc.action?am.uuid=${applicationId}" style="color:white;">[ 点击下载申请文档 ]</a>
		                </div>
                    </td>
                </tr>
            </table>
			<table  style="margin-top:50px;">
				<tr>
                    <td>
                    		<span class="textTitle">审批意见</span>
                    </td>
                    <td>
                    		<textarea rows="5" cols="32" name="opinionContent" autofocus="autofocus" placeholder="审批意见......"></textarea>
                     </td>
                </tr>
			</table>
			</section>
			<br>
			<hr>
	            <div class="buttons">
	                <div class="button submit agree">
	             		<a href="javascript:;" style="color:white;text-decoration:none">同意</a>
	                </div>
	                <div class="button submit refuse">
	             		<a href="javascript:;" style="color:white;text-decoration:none">不同意</a>
	                </div>
	                <div class="button return">
	             		<a href="javascript:history.back();" style="color:white;text-decoration:none">返回</a>
	                </div>
	            </div>
            <br>
        </s:form>
    </div>
</div>
<div class="decorate">
	<div class="row">
		<div class="col-md-12">
			<div class="note note-success">
			  <p>概要说明</p>
              <ul>
                <li>同意：本次审批通过，流程继续执行。如果所有的环节都通过，则表单的最终状态为：已通过。</li>
                <li>不同意：本次审批未通过，流程结束，不再继续执行。表单的最终状态为：未通过。</li>
                <li>如果点击了同意，并且当前节点中有多个Transition，则会弹出一个窗口选择要使用的Transition。</li>
                <li>退文（回退）：就是将表单退回到当前节点以前的任意一个节点，包括上一步和发起人。<br>&nbsp;&nbsp;
                		接到退文的审批人对表单重新审批，审批通过后继续按原预设的流程进行流转，原先已经审批过的审批人需要重新审批。<br>&nbsp;&nbsp;
                		比如，一个审批单的审批流程是：甲→乙→丙→丁。丙在审批的时候，选择了退文到甲，那么这个流程实际就变成了：甲→乙→丙→甲→乙→丙→丁。
                </li>
              </ul>
			</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		$(".agree").click(function(){
			$("form:first").submit();
		});
		$(".refuse").click(function(){
			$("#approval").val("false");
			$("form:first").submit();
		});
	})
</script>
</body>
</html>
