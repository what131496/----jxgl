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
			<table class="datatable" border="1" width="780">
				<tr class="">
					<td colspan="2">对不起，您输入的路径有误</td>
				</tr>
				<tr class="">
					<td colspan="2"><a href="<%=path %>/login.jsp" target="right">请返回登录</a></td>
				</tr>
			</table>
			<br />
		
	</div>
	</body>
</html>
