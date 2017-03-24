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
    </style>
  </head>
  <body>
	<div class="page-container">
		<div class="container">
		  <div class="row">
		    <div class="span9" style="width: 100%;margin:8px;">
		      <hr>
		      <h4>流程视图</h4>
		      <div class="stats">
		        <div class="row-fluid">
		          <div class="span3">
		            <div class="stat info">
		              <h2>${pdList.size() }</h2>
		              <h6>审批流程</h6>
		            </div>
		          </div>
		          <div class="span3">
		            <div class="stat danger">
		              <h2>04</h2>
		              <h6>待我审批</h6>
		            </div>
		          </div>
		          <div class="span3">
		            <div class="stat warning">
		              <h2>${tmList.size() }</h2>
		              <h6>表单模板</h6>
		            </div>
		          </div>
		          <div class="span3">
		            <div class="stat inverse">
		              <h2>${userCount}</h2>
		              <h6>管理员</h6>
		            </div>
		          </div>
		        </div>
		      </div>
		      <hr>
		      <div class="row-fluid">
		        <div class="span6">
		          <div class="table-panel">
		            <h4> <i class="icon-eye-open"></i>审批流程项</h4>
		            <table class="table table-striped sortable">
		              <thead>
		                <tr>
		                  <th>流程名称</th>
		                  <th>最新版本</th>
		                </tr>
		              </thead>
		              <tbody>
		               	<s:iterator value="pdList">
		               		<tr>
			                    <td>${name}</td>
			                    <td>${version}</td>
		                    </tr>
		               	</s:iterator>
		              </tbody>
		            </table>
		          </div>
		        </div>
		        <div class="span6">
		          <div class="table-panel">
		            <h4> <i class="icon-share-alt"></i>表单模板项</h4>
		            <table class="table table-striped sortable">
		              <thead>
		                <tr>
		                  <th>模板名称</th>
		                  <th>对应流程</th>
		                </tr>
		              </thead>
		              <tbody>
		                <s:iterator value="tmList">
		               		<tr>
			                    <td>${name}</td>
			                    <td>${pdKey}</td>
		                    </tr>
		               	</s:iterator>
		              </tbody>
		            </table>
		          </div>
		        </div>
		      </div>
		      <hr>
		      <h4>轻松一下</h4>
		      <div class="panel">
		        <div class="top primary"><i class="batch-big b-database"></i>
		          <h6>装逼指数</h6>
		        </div>
		        <div class="bottom">
		          <h6>满血点</h6>
		          <h2>90%</h2>
		        </div>
		      </div>
		      <div class="panel">
		        <div class="top warning"><i class="batch-big b-flag"></i>
		          <h6>魅力指数</h6>
		        </div>
		        <div class="bottom">
		          <h6>血槽值</h6>
		          <h2>99.99%</h2>
		        </div>
		      </div>
		      <div class="panel">
		        <div class="top success"><i class="batch-big b-code"></i>
		          <h6>泡妞指数</h6>
		        </div>
		        <div class="bottom">
		          <h6>潜能魅力值</h6>
		          <h2>100%</h2>
		        </div>
		      </div>
		      <div class="panel">
		        <div class="top danger"><i class="batch-big b-comment"></i>
		          <h6>屌丝指数</h6>
		        </div>
		        <div class="bottom">
		          <h6>吐槽血点</h6>
		          <h2>0.04%</h2>
		        </div>
		      </div>
		      <div class="panel">
		        <div class="top"><i class="batch-big b-alarm"></i>
		          <h6>精神气质</h6>
		        </div>
		        <div class="bottom">
		          <h6>活力十足</h6>
		          <h2>98.87%</h2>
		        </div>
		      </div>
		      <div class="panel">
		        <div class="top purple"><i class="batch-big b-wifi"></i>
		          <h6>蹭wifi技能</h6>
		        </div>
		        <div class="bottom">
		          <h6>预估值</h6>
		          <h2>86%</h2>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
      </div>
  </body>
</html>