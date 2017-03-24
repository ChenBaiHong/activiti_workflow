<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <title>工作流管理</title>
    <meta charset="utf8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="html/assets/global/plugins/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="html/assets/global/plugins/bootstrap/css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="html/baiHoo/css/styles.css" />
    <style>
    body {
		font-family:"黑体";
    	font-size:16px;
    	background-color: transparent;
	}
	.page {
	    background: rgba(225,225,225,0.7);
	}
    .panel {
        margin: 11px 20px;
    }
    	.decorate {
    		margin-top: 6%;
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
		.button {
			display:inline-block;
            padding: 7px 15px;
            background-color: #3c6db0;
            text-align: center;
            border-radius: 0px;
            overflow: hidden;
            min-width: 80px;
            border: none;
            color: #FFF;
            box-shadow: 1px 1px 1px rgba(75, 75, 75, 0.3);
            /* cursor:pointer; */
        }
        .button:hover { background-color: #5a88c8;}
    </style>
  </head>
  <body>
	<div class="page-container">
		<div class="container">
		  <div class="row">
		    <div class="span9" style="width: 100%;margin:8px;">
		      <hr>
		      <h4>申请表单模板选择</h4>
		      <div class="stats">
		        <div class="row-fluid">
		      <div class="row-fluid">
		      <hr>
		     <s:iterator value="templateList">
		     	<s:a action="application_appUI"> 
		     		<s:param name="templateUuid" value="uuid"></s:param>
		     		<div class="panel">
				        <div class="top primary"><i class="batch-big b-flag"style="background:url(html/assets/global/img/WinWordLog.png);background-size:cover;"></i>
				          <h6>${name}</h6>
				        </div>
				        <div class="bottom">
				           <h4>office Word</h4>
		          			<h4>文档模板</h4>
				        </div>
				     </div>
		     	</s:a>
		      </s:iterator>
				      <div class="decorate">
							<div class="col-md-12">
								<div class="buttons">
						             <div class="button">
						             	<a href="javascript:;" style="color:white;text-decoration:none;">申请流程模板</a>
						             </div>
						         </div>
								<div class="note note-success">
								  <p>说明概述</p>
					              <ul>
					                <li>1.	列表显示的是所有流程定义（不同名称）的最新版本。</li>
					                <li>2.	删除流程定义时，此名称的所有版本的流程定义都会被删除。</li>
					              </ul>
								</div>
							</div>
			  		</div>
		    </div> 
		</div>
      </div>
  </body>
</html>