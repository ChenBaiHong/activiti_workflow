<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>流程定义显示列表</title>
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
    <script type="text/javascript" src="html/assets/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="html/assets/global/plugins/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
   		function showMsgDialog(key){
   			//alert(top.$("button.md-trigger16").index())
   			top.$("button.md-trigger16").trigger("click");
   			//top.$(".btContainer").find(".md-trigger").eq(top.$("button.md-trigger16").index()).trigger("click");
   			top.$("#hide-val").val("processDefinition_deleteProcessDefinition?pdqm.key="+key);
   			top.$("#modal-16").find(".dialog-content").find("h3").html("是否删除当前流程定义？"); 
   		}
   		function showProcessImg(id , name){
   			//alert(top.$("button.md-trigger8").index())
   			top.$("button.md-trigger8").trigger("click");
   			//top.$(".btContainer").find(".md-trigger").eq(top.$("button.md-trigger8").index()).trigger("click");
   			top.$("#processImg").attr("src","processDefinition_viewProcessPicture.action?pdqm.id="+id);
   			top.$("#modal-8").find(".dialog-content").find("h3").html("[ "+name+" ] 的流程图"); 
   		}
    </script>
  </head>
  <body>
  	<hr>
    <div class="header">
		<a class="link title-ani"  data-letters="审批流程管理">审批流程管理</a>
        <br>
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
                <h5>流程定义列表</h5>
                <div class="widget-buttons">
                  <%-- <a href="dep_input.action" data-title="Collapse" data-collapsed="false" class="tip collapse">
                  		<span class="label label-success" style="font-size:16px ; padding:5px;"><i class="icon-external-link"></i>&nbsp;&nbsp;新建</span>
                  	</a> --%>
                </div>
              </div>
              <s:form action="dep_list.action" method="post">
              <div class="widget-body"><!-- widget-body -->
              	<div class="searchPanle row-fluid" style="width:auto; ">
              		
                </div>
                <table id="users" class="table table-striped table-bordered dataTable">
                  <thead>
                  <tr>
                    <th>流程名称</th>
                    <th>最新版本</th>
                    <th>概述说明</th>
                    <th>相关操作</th>
                    <th>查阅流程图</th>
                  </tr>
                  </thead>
                  <tbody>
                  <s:iterator value="pdList">
                  		<tr>
		                    <td>${name}</td>
		                    <td>${version}</td>
		                    <td>${description}</td>
		                    <td>
		                    	<button class="btn btn-warnings" type="button">
				                  	<a  href="javascript:void(0)" onclick="showMsgDialog('${key}')"><i class="icon-trash"></i> 删除</a>
				                  </button>
		                    </td>
		                    <td>
		                    	<button class="btn btn-success" type="button">
		                    		<a  href="javascript:void(0)" style="color:white;" onclick="showProcessImg('${id}','${name}')"><i class="icon-trash"></i> 流程图</a>
				                </button>
		                    </td>
		                  </tr>
                  </s:iterator>
                  </tbody>
                </table>
              </div> <!-- /widget-body -->
            </s:form>
            </div> <!-- /widget -->
          </div> <!-- /row-fluid -->
		</div>
		<!-- /Main window -->
		<div class="decorate">
			<div class="buttons">
	             <div class="button">
	             	<a href="processDefinition_input.action" style="color:white;">部署流程定义文档</a>
	             </div>
	         </div>
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
    </div><!--/.fluid-container-->
    </div><!-- wrap ends-->
  </body>
</html>