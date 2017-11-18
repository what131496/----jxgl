<%@ page language="java" import="java.util.Calendar" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s" %>
    <% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="shortcut icon" href="../img/icon.ico" />
		<script type="text/javascript" src="../js/time.js" ></script>
	</head>
	<style>
		.top-main{ background:url("../img/index/title1.png"); height: 150px; width: 1376px;
		 margin-left: -10px; margin-top: -8px;}
		.top-menu{ width: 355px; margin-left: 1060px; margin-top: -78px;
		display: inline-block;float: right; }
		.top-menu b{ height: 25px; display: inline-block; line-height: 20px;font-weight: 500;}
		.top-menu img{  margin-right: 5px; margin-top: 5px;}
		.title{ width: 999px; height: 50px;display: inline-block;}
		.top-menu span{ height: 40px;line-height: 40px;color: white;margin-left:5px }
		.top-menu a{ text-decoration: none; color: white;}
		.time{ height: 40px; width: 740px; margin-left: 210px;margin-top:58px; color: white; font-weight: bold;display: inline-block; }
		.semester{color:white;margin-bottom: 6px;margin-left:35px}
	</style>
	<body>
		<div class="top-main clearfix">
				<!--<img class="title" src="img/index/title.png">-->
			<div class="time">
			     <marquee behavior="alternate" scrollamount="2" width="780px"><span class="a_time" id="show">时间显示</span></marquee>
		    </div>	
		   
			<div class="top-menu">
				<div class="semester">
					<%
						Calendar c=Calendar.getInstance();
				        int i = c.get(Calendar.WEEK_OF_YEAR);
					%>
					2017-2018学年第一学期  第<%=i-34%>周
				</div>
				<span><img src="../img/index/user1.png"/><b>敬爱的老师：<s:property value="#session.exitUsers.getUserName()" /></b></span>
				<span><b><a href=""  onclick="javascript:window.parent.frames['right'].location.reload();"><img src="../img/index/break.png"/>刷新</a></b></span>
				<span><b><a href="<%=path%>/exit.jsp" target="_top" onclick="return confirm('确认退出吗')"><img src="../img/index/exit.png"/>退出</a></b></span>
			</div>
		</div>
	</body>
</html>
