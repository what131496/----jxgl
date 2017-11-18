<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=path%>/front/css/main.css" />
	</head>
	<style>
	  .datatable tr:hover,.datatable tr.hilite
	    {
	    background-color:rgba(2,146,172,0.5);
	    
		 }
		 table tr td{height: 35px;}
		 
	</style>
	<script>
	 var rows = document.getElementsByTagName('tr');//取得行
	    for(var i=0 ;i<rows.length; i++)
	    {
	        rows[i].onmouseover = function(){//鼠标移上去,添加一个类'hilite'
	            this.className += 'hilite';
	        };
	        rows[i].onmouseout = function(){//鼠标移开,改变该类的名称
	            this.className = this.className.replace('hilite','');
	        };
	    }
	</script>
	<body>
		<div class="info">
		<s:form id="saveForm" action="Courses_update" method="post" namespace="/" theme="simple">
			<table class="datatable" border="1" width="680">
				<tr>
					<td>课程号</td>
					<td><s:textfield  name="cour_id" value="%{model.cour_id}"/></td>
				</tr>
				<tr>
					<td>课程名</td>
					<td><s:textfield name="cour_name"  value="%{model.cour_name}" /></td>
				</tr>
				<tr>
					<td>周学时</td>
					<td><s:textfield name="cour_hour"  value="%{model.cour_hour}" /></td>
				</tr>
				<tr>
					<td>学期</td>
					<td><s:textfield name="semester"  value="%{model.semester}" /></td>
				</tr>
				
				<tr>
					<td>学分</td>
					<td><s:textfield name="credit"  value="%{model.credit}" /></td>
				</tr>
					<s:hidden name="flag" value="%{model.flag}"/>
				<tr>
					<td>课程类型</td>
					<td>1,2,3  分别表示：专业必修，公共必修，公共选修<s:textfield  name="type"  value="%{model.type}"/></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit cssClass="btn_submint" value="提交"/></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
