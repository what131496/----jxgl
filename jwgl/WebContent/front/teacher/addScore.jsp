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
		<form action="${pageContext.request.contextPath}/Score_update" method="post">
			<table class="datatable" border="1" width="780">
				<tr class="tableTiltle">
					<td colspan="2" >学生姓名</td>
					<td colspan="2" >学生学号</td>
					<td colspan="2" >性别</td>
					<td colspan="2" >课程号</td>
					<td colspan="2" >成绩</td>
				</tr>
			<s:iterator value="addScore" var="d">
				<tr>
					<input type="hidden" name="stu_id" value="<s:property value="#d.stu_id" />">
					<input type="hidden" name="cour_id" value="<s:property value="#d.cour_id" />">
					<td colspan="2" ><s:property value="#d.stu_name" /></td>
					<td colspan="2" ><s:property value="#d.stu_id" /></td>
					<td colspan="2" ><s:property value="#d.stu_sex" /></td>
					<td colspan="2" ><s:property value="#d.cour_id" /></td>
					<td colspan="2" ><input type="number" name="scored" style="width:110px;" min="0" max="100" placeholder="必须是0到100"  /></td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="12" ><input class="btn_submint" type="submit"  value="确定保存"></td>
				</tr>
			</table>
		</form>
			<br />
	</div>
	
	</body>
</html>
