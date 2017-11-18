<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
    <% String path=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>教学管理系统</title>
        <link rel="stylesheet" type="text/css" href="../css/reset.css" />
        <link rel="stylesheet" type="text/css" href="../css/main.css" />
        <link rel="stylesheet" type="text/css" href="../js/tree_themes/SimpleTree.css"/>
        <script type="text/javascript" src="../js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/SimpleTree.js"></script>
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
    <body background="../img/index/left.png">
    	<div class="st_tree">
		<ul>
			<li><a href="right.jsp" target="right" >欢迎界面</a></li>
			<li><a href="#"></a>教师信息管理</li>
		    <ul show="true">
		    	<li><a href="Teachers_findById" target="right">个人信息</a></li>
				<li><a href="Teachers_find" target="right">修改信息</a></li>
				<li><a href="modifyPass.jsp" target="right">修改密码</a></li>
			</ul>
			<li><a href="#" ref="ckgl"></a>成绩管理</li>
		    <ul show="true">
				<li><a href="../score/allScore.jsp" target="right">按照班级</a></li>
				<li><a href="Teachers_thisCourses" target="right">按照课程</a></li>
			</ul>
			<li><a href="#"></a>课程申请</li>
		    <ul>
				<li><a href="../courses/addCourses.jsp" target="right">申请提交</a></li>
				<li><a href="Courses_findByTeacher" target="right">结果查看</a></li>
			</ul>
		</ul>
		</div>
		<div class="foot">
			欢迎您：<s:property value="#session.exitUsers.getUserId()"/>
		</div>
 	</body>
</html>