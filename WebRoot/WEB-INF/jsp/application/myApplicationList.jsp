<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>管理员列表</title>
    <link href="html/assets/global/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="html/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <style type="text/css">
    body {
            background-color: transparent;
            text-align: center;
        }
    	.widget-header {
    background-color: #efefef;
    -moz-border-radius: 3px 3px 0 0;
    -webkit-border-radius: 3px 3px 0 0;
    border-radius: 3px 3px 0 0;
    min-height: 51px;
    border: 1px solid #DDDDDD;
}
    	.widget-header::before, .widget-header::after {
    content: "";
    display: table;
    line-height: 0;
}
    	.widget-header::after {
    clear: both;
}
    	.widget-header > i, .widget-header h5 {
    float: left;
    color: #62687e;
    font-weight: 200;
}
    	.widget-header > i {
    font-size: 16px;
    padding: 15px 10px 15px 11px;
    text-align: center;
    width: 40px;
}
    	.widget-buttons {
    float: right;
    padding: 15px 15px 0 0;
}
    	.widget-header a {
    color: #777777;
    cursor: pointer;
    font-size: 16px;
    margin: 0 0 0 8px;
    text-decoration: none;
}
    	.widget-header a {
    color: #777777;
    cursor: pointer;
    font-size: 16px;
    margin: 0 0 0 8px;
    text-decoration: none;
}
    	.collapse {
    position: relative;
    height: 0px;
    overflow: hidden;
    -webkit-transition: height 0.35s ease;
    -moz-transition: height 0.35s ease;
    -o-transition: height 0.35s ease;
    transition: height 0.35s ease;
}
    	.widget {
    -moz-border-radius: 3px 3px 3px 3px;
    -webkit-border-radius: 3px 3px 3px 3px;
    border-radius: 3px 3px 3px 3px;
    overflow: hidden;
}
.widget-padding .widget-body {
    padding: 15px;
}
.widget-body {
    padding: 0;
    border-style: solid;
    border-width: 0 1px 1px;
    border-color: #ccc;
    background-color: #fff;
}
.widget-body table thead tr th{
	text-align:center;
	vertical-aalign:middle;
}
.widget-body table tbody tr td{
 	text-align: center;
 	vertical-align:middle;
}
.searchPanle  .span6{
	margin-left :0px;
	width : 20%;
}
.searchPanle  .span6 .dataTables_filter label input[type="text"]{
	height:30px; 
}
.searchPanle .label:hover{
	background: rgba(82, 168, 236, 0.8);
}

    	/*****************************************************/
        /*****************************************************/
        /*****************************************************/
        /*****************************************************/
		.widget-header {
		    background-color: rgba(1, 1, 1, 0.2);
		}
		.widget-body {
		    background-color: rgba(225, 225, 225, 0.5);
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
		 /*****************************************************/
        /*****************************************************/
        /*****************************************************/
        /*****************************************************/
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
        background: #ffa93c;
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
    </style>
    <script type="text/javascript" src="html/assets/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="html/assets/global/plugins/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
   		function showProcessPNG(uuid ,name){
   			top.$("button.md-trigger4").trigger("click");
   			top.$("#viewPicture").attr("src","application_showProcessPNG.action?am.uuid="+uuid);
   			top.$("#modal-4").find(".dialog-content").find("h3").html("[ "+name+" ] 的流程图"); 
   			//alert(top.$("#modal-4").find(".dialog-content").find("h3").html());
   		}
    </script>
  </head>
  <body>
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
    <div id="wrap">
    <div class="container-fluid">
      	<!-- Main window -->
		<div class="main_container">
          <div class="row-fluid">
            <div class="widget widget-padding span12">
              <div class="widget-header" style="border-bottom-style:none;">
                <i class="icon-group"></i>
                <h5>管理员列表</h5>
                <div class="widget-buttons">
                  <%-- <a href="dep_input.action" data-title="Collapse" data-collapsed="false" class="tip collapse">
                  		<span class="label label-success" style="font-size:16px ; padding:5px;"><i class="icon-external-link"></i>&nbsp;&nbsp;新建</span>
                  	</a> --%>
                </div>
              </div>
              <s:form action="application_myApplicationList" method="post" cssStyle="padding-bottom:22px;">
              <div class="widget-body"><!-- widget-body -->
              	<div class="searchPanle row-fluid" style="width:auto; ">
              		<div class="span6">
	              		<div class="dataTables_length">
	              			<label>
	              					申请状态：
	              					<s:select  list="@com.baiHoo.activiti.application.vo.ApplicationModel@statusMap" name="aqm.status"  headerKey="-1" headerValue="---请-选-择---" cssClass="changeCount"></s:select>
	              				</label>
	              		</div>
              		</div>
                </div>
                <table id="users" class="table table-striped table-bordered dataTable">
                  <thead>
                  <tr>
                    <th>标题</th>
                    <th>申请人</th>
                    <th>申请日期</th>
                    <th>申请状态</th>
                    <th>相关操作</th>
                  </tr>
                  </thead>
                  <tbody>
                  <s:iterator value="applicationList">
                  		<tr>
		                    <td>${title}</td>
		                    <td>${applicant.userName}</td>
		                    <td><s:date name="applyDate" format="yyyy-MM-dd HH:mm:ss"/></td>
		                    <td>
		                    	<s:if test="status == @com.baiHoo.activiti.application.vo.ApplicationModel@STATUS_APPROVING">
		                    			<a  href="javascript:;" onclick="showProcessPNG('${uuid}','${tm.name}')">${statusView}</a>
		                    	</s:if>
		                    	<s:else>
		                    			 ${statusView}
		                    	</s:else>
		                    </td>
		                    <td>
		                      <div class="btn-group">
		                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#" style="background-color:#DDD;">
		                          选择操作
		                          <span class="caret"></span>
		                        </a>
		                        <ul class="dropdown-menu pull-right">
		                          <li>
		                          		<a href="application_downloadAppDoc.action?am.uuid=${uuid}" class="download">[ 下载我的申请 ]</a>
		                          </li>
		                          <li>
		                          		<s:a action="processController_approveInfoUI.action">
											<s:param name="applicationId" value="uuid"/>
											 查看流转记录
										</s:a>
		                        </ul>
		                      </div>
		                    </td>
		                  </tr>
                  </s:iterator>
                  </tbody>
                </table>	
                 <%@include file="/WEB-INF/jsp/tools/pagination.jsp"%>
              </div> <!-- /widget-body -->
            </s:form>
            </div> <!-- /widget -->
          </div> <!-- /row-fluid -->
          		<div class="decorate">
					<div class="row">
						<div class="col-md-12">
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
		</div><!-- /Main window -->
    </div><!--/.fluid-container-->
    </div><!-- wrap ends-->
  </body>
</html>