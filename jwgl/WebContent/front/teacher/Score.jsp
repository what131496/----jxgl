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
		<form action="Score_update" method="post">
					<input type="text" name="stu_id" value="2014163201">
					<input type="text" name="cour_id" value="20101" />
					<input type="text"  placeholder="必须是0到100"  name="scored" >
					<input type="text" name="stu_id" value="2014163201">
					<input type="text" name="cour_id" value="20101" />
					<input type="text" name="scored" value="85">
					<input type="text" name="stu_id" value="2014163201">
					<input type="text" name="cour_id" value="20101" />
					<input type="text" name="scored" value="85">
					<input type="submit"  value="提交">
		</form>
	</div>
	<form action="Score_update" method="post">
	<input type="text" name="stu_id" value="001">
	<input type="text" name="stu_id" value="002">
	<input type="text" name="stu_id" value="003">
	<input type="text" name="cour_id" value="001">
	<input type="text" name="cour_id" value="002">
	<input type="text" name="cour_id" value="003">
	<input type="submit"  value="提交">
</form>
	</body>
</html>
