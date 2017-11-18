<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <% String path=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>教学管理系统</title>
        <link rel="stylesheet" type="text/css" href="css/reset.css" />
        <link rel="stylesheet" type="text/css" href="css/main.css" />
        <link rel="stylesheet" type="text/css" href="js/tree_themes/SimpleTree.css"/>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/SimpleTree.js"></script>
    </head>
    <script type="text/javascript">
		$(function(){
			$(".st_tree").SimpleTree({
				click:function(a){
					if(!$(a).attr("hasChild"))
						alert($(a).attr("ref"));
				}
			});
		});
	</script>
    <body background="img/index/left.png">
    	<div class="st_tree">
		<ul>
			<li><a href="right.jsp" target="right" >欢迎界面</a></li>
			<li><a href="#"></a>学生信息管理</li>
		    <ul show="true">
		    	<li><a href="Students_findById" onmouseover="window.status='1.jsp';return true" title="查看个人信息" target="right">个人信息</a></li>
		    	<li><a href="Students_find" target="right">修改信息</a></li>
				<li><a href="modifyPass.jsp" target="right">修改密码</a></li>
				<!-- <li><a href="欢迎您" onclick="window.location.href='aaa.jsp'" target="right">点击 </a> </li> -->
			</ul>
			<li><a href="#" ref="ckgl"></a>成绩查询</li>
		    <ul show="true">
				<li><a href="score/allScore.jsp" target="right">开学以来</a></li>
				<li><a href="Courses_findScore" target="right">本学期</a></li>
				<li><a href="#"></a>等级考试</li>
		        <ul>
		            <li><a href="score/CETScore.jsp" target="right">CET</a></li>
		            <li><a href="score/NcreScore.jsp" target="right">NCRE</a></li>
		        </ul>
			</ul>
			<li><a href="#"></a>选课</li>
		    <ul>
				<li><a href="Courses_findTotal" target="right">选修课程</a></li>
				<li><a href="Courses_findSelect" target="right">预选结果</a></li>
			</ul>
			<li><a href="#"></a>离返校报道</li>
		    <ul>
				<li><a href="leave.jsp" target="right">离校申请</a></li>
				<li><a href="#" target="right">查看通知</a></li>
			</ul>
			<li><a href="#"></a>开学报到</li>
		    <ul>
				<li><a href="leave.jsp" target="right">提交报道</a></li>
				<li><a href="Courses_findSelect" target="right">查看回馈</a></li>
			</ul>
		</ul>
		</div>
		<div class="foot">
			欢迎您：<s:property value="#session.exitUsers.getUserId()" />
		</div>
 	</body>
</html>