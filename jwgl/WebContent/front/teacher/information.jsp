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
		 .info input{height: 35px; border: none; outline: none; width:550px;text-indent: 10px;}
	</style>
	<body>
		<div class="info">
		  <s:form action="" method="post" namepace="/">
			<table class="datatable" border="1" width="780">
				<tr>
					<td>教师号</td>
					<td><s:property value="%{model.teach_id}" /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><s:property value="%{model.teach_name}" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><s:property value="%{model.teach_sex}" /></td>
				</tr>
				<tr>
					<td>出生年月</td>
					<td><s:property value="%{model.teach_birth}" /></td>
				</tr>
				<tr>
					<td>出生地</td>
					<td><s:property value="%{model.teach_birthplace}" /></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><s:property value="%{model.teach_email}" /></td>
				</tr>
				<tr>
					<td>联系方式</td>
					<td><s:property value="%{model.teach_telephone}" /></td>
				</tr>
				<tr>
					<td>系别</td>
					<td><s:property value="%{model.dept_id}" /></td>
				</tr>
				<tr>
					<td>职称</td>
					<td><s:property value="%{model.teach_professional}" /></td>
				</tr>
				<tr>
					<td>研究方向</td>
					<td><s:property value="%{model.teach_research}" /></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
