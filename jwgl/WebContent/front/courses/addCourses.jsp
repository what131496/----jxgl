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
		  <s:form action="Courses_add" method="post" namespace="/" theme="simple" >
			<table class="datatable" border="1" width="780">
				<s:hidden name="flag" value="0"/>
				<tr>
					<td>课程编号</td>
					<td align="center"><s:textfield name="cour_id" /></td>
				</tr>
				<tr>
					<td>课程名字</td>
					<td align="center"><s:textfield name="cour_name" /></td>
				</tr>
				<tr>
					<td>周课时</td>
					<td align="center"><s:textfield name="cour_hour" /></td>
				</tr>	
				<tr>
					<td>学期</td>
					<td align="center"><s:textfield name="semester" /></td>
				</tr>
				<tr>
					<td>学分</td>
					<td align="center"><s:textfield name="credit" /></td>
				</tr>
				<tr>
					<td>课程类型</td>
					<td align="center"><s:textfield name="type" placeholder="1,2,3" /></td>
				</tr>
				<tr>
					<td>总课时</td>
					<td align="center"><s:textfield name="lecture_time" placeholder="16-60之间" /></td>
				</tr>
				<tr>
					<td colspan="2" ><input class="btn_submint" type="submit"  value="确定保存"></td>
				</tr>
			</table>
		</s:form>
	</div>
	</body>
</html>
