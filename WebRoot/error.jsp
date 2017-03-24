<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <style>
  html {
    font-size: 16px;
    font-family: "微软雅黑","黑体";
}
   	
   body {
       background-color: transparent;
       text-align: center;
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


    </style>
</head>
<body>
<script type="text/javascript">
	window.onload=function(){
			var title = document.getElementById("title");
			var text  = title.text;
			title.setAttribute("data-letters",text.trim())
	}
</script>
<div class="page">
	<s:debug/>
    <div class="header">
		<a class="link title-ani"  id="title"data-letters="" style="margin-top: 15%;font-size: 100px;"><s:actionerror/></a>
        <br>
    </div>
</div>
</body>
</html>
