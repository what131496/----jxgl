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
		<s:form id="saveForm" action="Teachers_save" method="post"
		namespace="/" theme="simple">
			<table class="datatable" border="1" width="680">
				<tr>
					<td>教师号</td>
					<td><s:textfield name="teach_id" /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><s:textfield name="teach_name"   /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><s:radio cssStyle="height:15px; width:18px" name="teach_sex" list="{'男','女'}"   /></td>
				</tr>
				<tr>
					<td>出生年月</td>
					<td><input type="text" name="teach_birth"  /></td>
				</tr>
				<tr>
					<td>籍贯地</td>
					<td><s:textfield name="teach_birthplace"   /></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><s:textfield name="teach_email"   /></td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td><s:textfield name="teach_telephone"   /></td>
				</tr>
				<tr>
					<td>系别</td>
					<td><s:textfield name="dept_id"  /></td>
				</tr>
				<tr>
					<td>职称</td>
					<td><s:textfield name="teach_professional"  /></td>
				</tr>
				<tr>
					<td>研究方向</td>
					<td><s:textfield name="teach_research"   /></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit cssClass="btn_submint" value="提交"/></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
