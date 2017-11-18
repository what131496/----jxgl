<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../css/main.css" />
	</head>
	<style>
	
		 table tr td{height: 38px; width:230px}
		 .info input{height: 37px; border: none; outline: none; width:260px;text-indent: 10px;}
	</style>
	<body>
		<div class="info">
		<s:form action="User_save" method="post">
			<table class="datatable" border="1" width="380">
				<tr>
					<td colspan="2">用户信息添加</td>
				</tr>
				<tr>
					<td>编号</td>
					<td><input type="text" name="UserId"  required="required"></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="UserName" required="required"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="text" name="UserPass" required="required"></td>
				</tr>
				<tr>
					<td>身份</td>
					<td><input type="text" name="Role" placeholder="0是学生，1是教师，2是管理员" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn_submint" type="submit" value="确定添加"></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
