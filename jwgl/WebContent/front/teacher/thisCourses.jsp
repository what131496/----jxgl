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
		 table tr td{height: 35px; width:130px}
	</style>
	<body>
		<div class="info">
			<table class="datatable" border="1" width="780">
				<tr>
					<td colspan="8" >您当前的教授课程为</td>
				</tr>
				<tr class="tableTiltle">
					<td >课程号</td>
					<td >课程名</td>
					<td >学时数</td>
					<td >学期</td>
					<td >学分</td>
					<td >课程类型</td>
					<td >单个录入</td>
					<td >批量录入</td>
				</tr>
			<s:iterator value="thisCourses" var="d">
				<tr>
					<td align="center"><s:property value="#d.cour_id" /></td>
					<td align="center"><s:property value="#d.cour_name" /></td>
					<td align="center"><s:property value="#d.cour_hour" /></td>
					<td align="center"><s:property value="#d.semester" /></td>
					<td align="center"><s:property value="#d.credit" /></td>
					<td align="center">
						<s:if test="#d.type==1">专业课/必修课</s:if>
						<s:if test="#d.type==2">公共课/必修课</s:if>
						<s:if test="#d.type==3">公共课/选修课</s:if>
					</td>
					<td  >
						<a href="${pageContext.request.contextPath}/Teachers_addScores.action?cour_id=<s:property value="#d.cour_id"/>">
						<img src="${pageContext.request.contextPath}/front/img/edit.png"></a>
					</td>
					<td  >
						<a href="${pageContext.request.contextPath}/Teachers_addScore.action?cour_id=<s:property value="#d.cour_id"/>">
						<img src="${pageContext.request.contextPath}/front/img/edit.png"></a>
					</td>
				</tr>
			</s:iterator>
			</table>
			<br />
	</div>
	<s:debug></s:debug>
	</body>
</html>
