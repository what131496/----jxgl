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
	<s:actionmessage cssStyle="list-style-type:none;" escape="false"/>
	<body>
		<div class="info">
			<table class="datatable" border="1" width="780">
				<tr class="tableTiltle">
					<td>用户编号</td>
					<td>姓名</td>
					<td>密码</td>
					<td>角色</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
				<s:iterator value="list" var="d">
				<tr>
					<td align="center"><s:property value="#d.UserId" /></td>
					<td align="center"><s:property value="#d.UserName" /></td>
					<td align="center"><s:property value="#d.UserPass" /></td>
					<td align="center">
						<s:if test="#d.Role==0">学生</s:if>
						<s:if test="#d.Role==1">教师</s:if>
						<s:if test="#d.Role==2">管理员</s:if>
					</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/User_edit.action?UserId=<s:property value="#d.UserId"/>"><img
						src="${pageContext.request.contextPath}/front/img/edit.png"></a></td>
					<td align="center"><a onclick="return confirm('确认删除吗？')"
						href="${pageContext.request.contextPath}/User_delete.action?UserId=<s:property value="#d.UserId"/>"><img
						style="height:25px;width:25px"	src="${pageContext.request.contextPath}/front/img/delete.png"></a></td>
				</tr>
			</s:iterator>
			</table>
			<br />
		<table border="0" cellspacing="0" cellpadding="0" width="780px">
			<tr>
				<td align="right"><span>第<s:property value="currPage" />/<s:property
							value="totalPage" />页
				</span>&nbsp;&nbsp; <span>总记录数：<s:property value="totalCount" />&nbsp;&nbsp;每页显示：<s:property
							value="pageSize" />条
				</span>&nbsp;&nbsp; <span> 
				<s:if test="currPage!=1">
					<a href="${pageContext.request.contextPath}/User_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
	       			<a href="${pageContext.request.contextPath}/User_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
     			</s:if> 
     			<s:if test="currPage!=totalPage">
					<a href="${pageContext.request.contextPath}/User_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
	       			<a href="${pageContext.request.contextPath}/User_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
     			</s:if>
				</span></td>
			</tr>
		</table>
	</div>
	<s:actionmessage/>
	</body>
</html>
