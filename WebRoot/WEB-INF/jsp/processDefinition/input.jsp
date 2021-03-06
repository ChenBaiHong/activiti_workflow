<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 	<title>部署流程定义</title>
    <meta charset="utf8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="html/assets/global/plugins/easyForm/js/easyform/easyform.css">
    <!-- <link rel="stylesheet" href="html/assets/global/plugins/Pikaday/css/pikaday.css">
    <link rel="stylesheet" href="html/assets/global/plugins/Pikaday/css/site.css"> -->
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
        input[type="button"], input[type="submit"],input[type="reset"],.button {
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
		input[type="button"], input[type="submit"],input[type="reset"],.button{font-size:16px ; }

		input[type="button"]:hover, input[type="submit"]:hover,input[type="reset"]:hover,.return:hover { background-color: #5a88c8;}

 		input[type="button"]:active, input[type="submit"]:active,input[type="reset"]:active,.return:active {background-color: #5a88c8;}
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
		
		.buttons .button{
		    display: inline-block;
		    border-radius: 2px;
		    margin-left: 25%;
		    text-align:center;
		}
		.buttons .return{
		    display: inline-block;
		    border-radius: 2px;
		    margin-right: 25%;
		    text-align:center;
		   background-color:#eee;
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
		.fileinput-button {
			color:white;
		 	padding: 5px;
		 	cursor:pointer;
    		border-radius: 3;
		    position: relative;
		    overflow: hidden;
		    background: #78CD51;
		    border-color: #78CD51;
		}
		
		.fileinput-button:hover, .fileinput-button:focus, .fileinput-button:active{
		    background-color: #6dbb4a;
		    border-color: #6dbb4a;
		    color: #ffffff;
		}
		input.inputFile{
			display:none;
		}
    </style>
    <script src="html/assets/global/plugins/easyForm/js/jquery-2.1.0.min.js"></script>
    <script src="html/assets/global/plugins/easyForm/js/easyform/easyform.js"></script>
</head>
<body>
<div class="page">
	<hr>
    <div class="header">
		<a class="link title-ani"  data-letters="部署流程定义">部署流程定义</a>
        <br>
    </div>
    <hr>
    <div class="form-div">
        <form id="reg-form" action="processDefinition_save.action" method="post" enctype="multipart/form-data">
            <section class="step1" style="width:83%;margin:auto;">
            <table>
                <tr>
                    <td>
                    <span class="fileinput-button">+ 上传zip文件</span>
                    <input type="file" name="resource" id="inputFile" class="inputFile">
                    </td>
                    <td>
                    	<input type="text" id="fileName"disabled="disabled" autocomplete="off"/>
                    </td>
                </tr>
            </table>
			</section>
			<br>
			<br>
            <div class="buttons">
                <div class="button submit">
             		<a href="javascript:;" style="color:white;text-decoration:none">保存</a>
                </div>
                <div class="button return">
             		<a href="javascript:history.back();" style="color:white;text-decoration:none">返回</a>
                </div>
            </div>
            <br>
        </form>
    </div>
</div>
<div class="decorate">
	<div class="row">
		<div class="col-md-12">
			<div class="note note-success">
			  <p>概述说明</p>
              <ul>
                <li>只接受zip扩展名的文件</li>
                <li>非法格式文件不予处理</li>
                <li>拒绝上传非法zip文件内容</li>
              </ul>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function (){
        var v = $('#reg-form').easyform();
        v.is_submit = false;
        $(".fileinput-button").click(function(){
        	$("#inputFile").trigger("click");
        });
        var flag=false;
        $("#inputFile").parent().change(function(){
	           	   var aFiles = document.getElementById("inputFile").files;
		           var fileName= aFiles[0].name;
		           if(fileName.trim().length==0 || 
		           		fileName.substring(fileName.lastIndexOf(".")+1,fileName.length)!="zip" ){
		           		alert("你必须选择正确的  [ zip ]  格式文件!"); 
		           		return;
		           }
		           $("#fileName").val(fileName);
		           flag=true;
        });
        $(".submit").click(function(){
	        if(flag){
	        	$("form:first").submit();
	        }
        });
       /*  function getObjectURL(file) {
		    var url = null;
		    if (window.createObjectURL != undefined) { // basic
		        url = window.createObjectURL(file);
		    } else if (window.URL != undefined) { // mozilla(firefox)
		        url = window.URL.createObjectURL(file);
		    } else if (window.webkitURL != undefined) { // webkit or chrome
		        url = window.webkitURL.createObjectURL(file);
		    }
		    return url;
	 	} */
    });
</script>
</body>
</html>
