<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<style>
	.myPagination ul li {
    line-height: 20px;
    display: inline-block;
    height: 20px;
    background: #3c6db0;
    margin-top: 10px;
    min-width: 30px;
    padding: 4 8;
	}
	.myPagination ul li a{
		color:#fff;
	}
	.myPagination ul li:hover {
	    background-color: #5a88c8;
	}
	.myPagination ul li.active{
	background-color: darkturquoise;
	};
</style>
<div class="row-fluid">
	<div class="mySpan">
		<s:hidden name="currentPage"></s:hidden>
		<div class="dataTables_info" >显示&nbsp;&nbsp;<span>${currentPage}</span>&nbsp;&nbsp;到&nbsp;&nbsp;<span>${totalPage}</span>&nbsp;&nbsp;页&nbsp;&nbsp;共&nbsp;&nbsp;<span>${totalData}</span>&nbsp;&nbsp;条数据</div>
	</div>
	<div class="mySpan">
		<div class="myPagination">
			<ul>
				<li  id="fir" ><a href="javascript:;">首页</a></li>
				<li  id="pre" class="prev disabled"><a href="javascript:;">上一页</a></li>
				<s:iterator value="pagination" var="num" status="record">
					<li class="${num==currentPage ? 'active' : ' '} num">
						<a href="javascript:;" class="aNum">${num}</a>
					</li>
				</s:iterator>
					<li id="next" class="next disabled"><a href="javascript:;">下一页</a></li>
					<li id="last" class="endPage"><a href="javascript:;">尾页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
   		$(function(){
   			//最大页=1，都隐藏
			//第一页，前2隐藏，后2显示		
			//最后一页，前2显示，后2隐藏
			//中间任意，都显示
			var pageNum = ${currentPage};
			var maxPageNum = ${totalPage}; 
			if(maxPageNum == 1){
				$("#fir").css("display","none");
				$("#pre").css("display","none");
				$("#next").css("display","none");
				$("#last").css("display","none");
			}else if(pageNum == 1){
				$("#fir").css("display","none");
				$("#pre").css("display","none");
				$("#next").css("display","inline-block");
				$("#last").css("display","inline-block");
			}else if(maxPageNum == pageNum){
				$("#fir").css("display","inline-block");
				$("#pre").css("display","inline-block");
				$("#next").css("display","none");
				$("#last").css("display","none");
			}else {
				$("#fir").css("display","inline-block");
				$("#pre").css("display","inline-block");
				$("#next").css("display","inline-block");
				$("#last").css("display","inline-block");
			}
			$(".data_search").click(function(){
				$("[name=currentPage]").val(1);
				$("form:first").submit();
			})
			$("#fir").click(function(){
				$("[name=currentPage]").val(1);
				$("form:first").submit();
			});
			$("#pre").click(function(){
				$("[name=currentPage]").val($("[name=currentPage]").val()-1);
				$("form:first").submit();
			});
			//下一页
			$("#next").click(function(){
				//收集页码值，将页码值设置为指定值，提交表单
				//获取原始页码值，然后+1，设置回去
				$("[name=currentPage]").val($("[name=currentPage]").val()*1+1);
				$("form:first").submit();
			});
			$("#last").click(function(){
				$("[name=currentPage]").val(maxPageNum);
				$("form:first").submit();
			});
			$(".num").click(function(){
				$("[name=currentPage]").val($(this).find(".aNum").text());
				$("form:first").submit();
			});
			$(".changeCount").change(function(){
				$("form:first").submit();
			})
   		})
    </script>