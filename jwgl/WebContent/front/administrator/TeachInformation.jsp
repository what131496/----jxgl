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
		.datatable{margin-left:-72px}
		 table tr td{height: 35px;}
	</style>
	<body>
		<div class="info">
			<table class="datatable" border="1" width="1150">
				<tr class="tableTiltle">
					<td>教工号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>系别号</td>
					<td>出生日期</td>
					<td width="180">出生地</td>
					<td>电话</td>
					<td>邮箱</td>
					<td>职称</td>
					<td>研究方向</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
				<s:iterator value="list" var="d">
				<tr>
					<td align="center"><s:property value="#d.teach_id" /></td>
					<td align="center"><s:property value="#d.teach_name" /></td>
					<td align="center"><s:property value="#d.teach_sex" /></td>
					<td align="center"><s:property value="#d.dept_id" /></td>
					<td align="center"><s:property value="#d.teach_birth" /></td>
					<td align="center"><s:property value="#d.teach_birthplace" /></td>
					<td align="center"><s:property value="#d.teach_telephone" /></td>
					<td align="center"><s:property value="#d.teach_email" /></td>
					<td align="center"><s:property value="#d.teach_professional" /></td>
					<td align="center"><s:property value="#d.teach_research" /></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/Teachers_edit.action?teach_id=<s:property value="#d.teach_id"/>"><img
						src="${pageContext.request.contextPath}/front/img/edit.png"></a></td>
					<td align="center"><a onclick="return confirm('确认删除吗？')"
						href="${pageContext.request.contextPath}/Teachers_delete.action?teach_id=<s:property value="#d.teach_id"/>"><img
						style="height:25px;width:25px"	src="${pageContext.request.contextPath}/front/img/delete.jpg"></a></td>
				</tr>
			</s:iterator>
			</table>
			<br />
		<table border="0" cellspacing="0" cellpadding="0" width="980px">
			<tr>
				<td align="right"><span>第<s:property value="currPage" />/<s:property
							value="totalPage" />页
				</span>&nbsp;&nbsp; <span>总记录数：<s:property value="totalCount" />&nbsp;&nbsp;每页显示：<s:property
							value="pageSize" />条
				</span>&nbsp;&nbsp; <span> 
				<s:if test="currPage!=1">
					<a href="${pageContext.request.contextPath}/Teachers_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
	       			<a href="${pageContext.request.contextPath}/Teachers_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
     			</s:if> 
     			<s:if test="currPage!=totalPage">
					<a href="${pageContext.request.contextPath}/Teachers_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
	       			<a href="${pageContext.request.contextPath}/Teachers_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
     			</s:if>
				</span></td>
			</tr>
		</table>
	</div>
	</body>
</html>
