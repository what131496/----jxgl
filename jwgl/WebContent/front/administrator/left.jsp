<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <% String path=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>社团管理中心</title>
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
			<li><a href="#"></a>用户信息</li>
		    <ul show="true">
		    	<li><a href="${pageContext.request.contextPath}/User_findAll" target="right">查看信息</a></li>
		    	<li><a href="User_saveUI" target="right">添加用户</a></li>
			</ul>
			<li><a href="#"></a>教师信息</li>
		    <ul show="true">
				<li><a href="Teachers_findAll" target="right">修改信息</a></li>
				<li><a href="Teachers_saveUI" target="right">添加教师</a></li>
			</ul>
			<li><a href="#" ref="ckgl"></a>学生信息</li>
		    <ul>
				<li><a href="Students_findAll" target="right">修改信息</a></li>
				<li><a href="Students_saveUI" target="right">添加学生</a></li>
			</ul>
			<li><a href="#"></a>课程管理</li>
		    <ul>
				<li><a href="Courses_findAll" target="right">修改课程信息</a></li>
				<li><a href="../courses/addCourses.jsp" target="right">添加课程</a></li>
				<li><a href="#"></a>申请管理</li>
				<ul>
		            <li><a href="Courses_verify" target="right">课程审批</a></li>
		            <li><a href="#" >选课查询</a></li>
		        </ul>
			</ul>
			<li><a href="#" ref="ckgl"></a>离返校管理</li>
		    <ul>
				<li><a href="outSchool_findAll" target="right">登记查看</a></li>
				<li><a href="export_export" target="right">导出登记表</a></li>
			</ul>
		</ul>
		</div>
		<div class="foot">
			欢迎您：<s:property value="#session.exitUsers.getUserId()" />管理员
		</div>
 	</body>
</html>