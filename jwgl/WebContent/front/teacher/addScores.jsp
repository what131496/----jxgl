<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <% String path=request.getContextPath(); 
    	String ip=request.getLocalAddr();
    %>
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
	<script>
	function f(){
		 var a = document.getElementsByTagName("input");    
		 if (a.length > 0)     
		 {      a.item(0).focus();     
			} 
		} 
	</script>
	<body>
		<div class="info">
			<table class="datatable" border="1" width="780">
				<tr class="tableTiltle">
					<td colspan="2" >学生姓名</td>
					<td colspan="2" >学生学号</td>
					<td colspan="2" >性别</td>
					<td colspan="2" >联系方式</td>
					<td colspan="2" >成绩</td>
					<td colspan="2" >保存操作</td>
				</tr>
			<s:iterator value="addScores" var="d">
				<tr>
					<s:form action="Score_save" method="post" namesapce="/" theme="simple">
						<input type="hidden" name="stu_id" value="<s:property value="#d.stu_id" />">
						<input type="hidden" name="cour_id" value="<s:property value="#d.cour_id" />">
						<td colspan="2" ><s:property value="#d.stu_name" /></td>
						<td colspan="2" ><s:property value="#d.stu_id" /></td>
						<td colspan="2" ><s:property value="#d.stu_sex" /></td>
						<td colspan="2" ><s:property value="#d.stu_telephone" /></td>
						<td colspan="2" ><input style="width:100px;" placeholder="必须是0到100" min="0" max="100"  type="number" name="score" value="<s:property value="#d.score"/>"></td>
						<td colspan="2" ><input class="score" type="submit" value="保存"></td>
					</s:form>
				</tr>
			</s:iterator>
			</table>
			<br />
	</div>
	<s:debug></s:debug>
	</body>
</html>
