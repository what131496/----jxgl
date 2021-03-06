<%@page import="com.opensymphony.xwork2.ActionContext" import="java.util.*"%>
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
			<table class="datatable" border="1" width="880">
				<tr class="tableTiltle">
					<td>课程编号</td>
					<td>课程名字</td>
					<td>学时数</td>
					<td>学期</td>
					<td>学分</td>
					<td>课程类型</td>
					<td>课程状态</td>
					<td>是否通过</td>
				</tr>
			<s:if test="list.size()==0">为空</s:if>
				<s:iterator value="list" var="d">
			<s:form action="Courses_verifySuccess" method="post" namespace="/" theme="simple" >
				<tr>
					<td align="center"><s:property value="#d.cour_id" /></td>
					<td align="center"><s:property value="#d.cour_name" /></td>
					<td align="center"><s:property value="#d.cour_hour" /></td>
					<td align="center"><s:property value="#d.semester" /></td>
					<td align="center"><s:property value="#d.credit" /></td>
					<td align="center">
						<s:if test="#d.type==1">专业课/必修课</s:if>
						<s:if test="#d.type==2">公共课/必修课</s:if>
						<s:if test="#d.type==3">公共课/选修课</s:if>
					</td>
					<td align="center">
						<s:if test="#d.flag==1">通过</s:if>
						<s:if test="#d.flag==0">审核中</s:if>
					</td>
					<input type="hidden" name="cour_id" value="<s:property value="#d.cour_id"/>">
					<td ><input class="score" type="submit" value="同意"></td>
				</tr>
			</s:form>
			</s:iterator>
			<s:else>
			  <tr>
				<td colspan="8">暂无审核课程</td>
			</tr>
			</s:else>
			</table>
	</div>
		 <s:debug />
	</body>
</html>
