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
				<tr class="tableTiltle">
					<td>课程编号</td>
					<td>课程名字</td>
					<td>学时数</td>
					<td>学期</td>
					<td>学分</td>
					<td>课程类型</td>
					<td>选择课程</td>
				</tr>
				<s:iterator value="list" var="d">
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
					<td align="center"><a
						href="${pageContext.request.contextPath}/CourseScore_select.action?cour_id=<s:property value="#d.cour_id"/>"><img
						src="${pageContext.request.contextPath}/front/img/edit.png">选择</a></td>
				</tr>
			</s:iterator>
			</table>
			<br />
		<%-- <table border="0" cellspacing="0" cellpadding="0" width="780px">
			<tr>
				<td align="right"><span>第<s:property value="currPage" />/<s:property
							value="totalPage" />页
				</span>&nbsp;&nbsp; <span>总记录数：<s:property value="totalCount" />&nbsp;&nbsp;每页显示：<s:property
							value="pageSize" />条
				</span>&nbsp;&nbsp; <span> 
				<s:if test="currPage!=1">
					<a href="${pageContext.request.contextPath}/Courses_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
	       			<a href="${pageContext.request.contextPath}/Courses_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
     			</s:if> 
     			<s:if test="currPage!=totalPage">
					<a href="${pageContext.request.contextPath}/Courses_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
	       			<a href="${pageContext.request.contextPath}/Courses_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
     			</s:if>
				</span></td>
			</tr>
		</table> --%>
	</div>
		 <s:debug />
	</body>
</html>
