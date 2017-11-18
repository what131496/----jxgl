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
		 table tr td{height: 35px;}
	</style>
	<body>
		<div class="info">
			<a href="export_export"><button  style="float:right;margin-bottom:5px">导出Excel</button></a>
			<table class="datatable" border="1" width="1050">
				<tr>
					<td colspan="10">信息科学技术学院公休日、节假日外出登记表</td>
				</tr>
				<tr class="tableTiltle">
					<td>姓名</td>
					<td>性别</td>
					<td>电话</td>
					<td>事由</td>
					<td>目的地</td>
					<td>备用联系人</td>
					<td>与本人关系</td>
					<td>联系方式</td>
					<td>离开时间</td>
					<td>返回时间</td>
				</tr>
				<s:iterator value="listc" var="d">
				<tr>
					<td align="center"><s:property value="#d.name" /></td>
					<td align="center"><s:property value="#d.sex" /></td>
					<td align="center"><s:property value="#d.phone" /></td>
					<td align="center"><s:property value="#d.reason" /></td>
					<td align="center"><s:property value="#d.place" /></td>
					<td align="center"><s:property value="#d.your_phone" /></td>
					<td align="center"><s:property value="#d.relationship" /></td>
					<td align="center"><s:property value="#d.re_phone" /></td>
					<td align="center"><s:property value="#d.leave_time" /></td>
					<td align="center"><s:property value="#d.back_time" /></td>
			</s:iterator>
			</table>
	</div>
	</body>
</html>
