<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=path %>/front/css/main.css" />
	</head>
	<style>
		 table tr td{height: 35px; width:230px}
	</style>
	<body>
		<div class="info">
		 <table border="0">
		 	<tr>
		 		<td>学院：信息科学技术学院</td>
		 		<td>班级：14信管</td>
		 		<td>学号：<s:property value="#students.stu_id" /></td>
		 	</tr>
		 	<tr>
		 		<td>姓名：<s:property value="#students.stu_name" /></td>
		 		<td>时间：2016-2017第一学期</td>
		 	</tr>
		 </table>
			<table class="datatable" border="1" width="780">
				<tr class="tableTiltle">
					<td colspan="2" >课程/环节</td>
					<td colspan="2" >成绩</td>
					<td colspan="2" >学分</td>
					<td colspan="2" >学时</td>
					<td colspan="2" >类别</td>
					<td colspan="2" >取得学分</td>
					<td colspan="2" >绩点</td>
					<td colspan="2" >学分绩点</td>
				</tr>
			<s:iterator value="listc" var="d">
				<tr>
					<td colspan="2" ><s:property value="#d.cour_name" /></td>
					<td colspan="2" ><s:property value="#d.score" /></td>
					<td colspan="2" ><s:property value="#d.credit" /></td>
					<td colspan="2" ><s:property value="#d.cour_hour" /></td>
					<td colspan="2" >
					<s:if test="#d.type==1">专业课/必修课</s:if>
					<s:if test="#d.type==2">公共课/必修课</s:if>
					<s:if test="#d.type==3">公共课/选修课</s:if>
					</td>
					<td colspan="2" ><s:property value="#d.credit" /></td>
					<td colspan="2" ><s:property value="#d.score/20" /></td>
					<td colspan="2" ><s:property value="#d.credit*#d.score/20" /></td>
				</tr>
			</s:iterator>
			</table>
		
			<br />
	</div>
	<s:debug></s:debug>
	</body>
</html>
