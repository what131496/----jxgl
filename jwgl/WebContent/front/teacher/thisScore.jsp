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
				<tr class="tableTiltle">
					<td colspan="2" >学生姓名</td>
					<td colspan="2" >学生学号</td>
					<td colspan="2" >性别</td>
					<td colspan="2" >成绩</td>
					<td colspan="2" >联系方式</td>
					<td colspan="2" >修改成绩</td>
				</tr>
			<s:iterator value="thisScore" var="d">
				<tr>
					<td colspan="2" ><s:property value="#d.stu_name" /></td>
					<td colspan="2" ><s:property value="#d.stu_id" /></td>
					<td colspan="2" ><s:property value="#d.stu_sex" /></td>
					<td colspan="2" ><s:property value="#d.score" /></td>
					<td colspan="2" ><s:property value="#d.stu_telephone" /></td>
					<td colspan="2" >
						<a href="${pageContext.request.contextPath}/Score_edit.action?stu_id=<s:property value="#d.stu_id"/>">
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
