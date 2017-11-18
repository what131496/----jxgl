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
		 .forget{margin:120px auto}
	</style>
	<body>
		<div class="info forget">
		  <form action="Users_forget" method="post">
			<table class="datatable" border="1" width="780">
				<tr class="tableTiltle">
					<td colspan="2">请您准确填写以下信息</td>
				</tr>
				<tr>
					<td>您的学号</td>
					<td><input type="text" name="stu_id" placeholder="登陆时候的证件号"></td>
				</tr>
				<tr>
					<td>您的姓名</td>
					<td><input type="text" name="stu_name" ></td>
				</tr>
				<tr>
					<td>您的电话</td>
					<td><input type="text" name="stu_telephone" placeholder="注册时候的电话"></td>
				</tr>
				<tr>
					<td>您的邮箱</td>
					<td><input type="text" name="stu_email" placeholder="注册时候的邮箱"></td>
				</tr>
				<tr>
					<td colspan="2" ><input class="btn_submint" type="submit"  value="确定提交"></td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>
