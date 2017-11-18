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
		  <form action="" method="post">
			<table class="datatable" border="1" width="780">
				<tr class="tableTiltle">
					<td colspan="2">操作成功，请选择其他操作</td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>
