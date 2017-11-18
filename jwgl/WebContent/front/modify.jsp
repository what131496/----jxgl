<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=path%>/front/css/main.css" />
	</head>
	<style>
	  .datatable tr:hover,.datatable tr.hilite
	    {
	    background-color:rgba(2,146,172,0.5);
	    
		 }
		 table tr td{height: 35px;}
		 
	</style>
	<script>
	 var rows = document.getElementsByTagName('tr');//取得行
	    for(var i=0 ;i<rows.length; i++)
	    {
	        rows[i].onmouseover = function(){//鼠标移上去,添加一个类'hilite'
	            this.className += 'hilite';
	        };
	        rows[i].onmouseout = function(){//鼠标移开,改变该类的名称
	            this.className = this.className.replace('hilite','');
	        };
	    }
	</script>
	<body>
		<div class="info">
		<s:form id="saveForm" action="Students_update" method="post"
		namespace="/" theme="simple">
			<table class="datatable" border="1" width="680">
				<tr>
					<td>学号</td>
					<td><s:textfield readonly="true"  name="stu_id" value="%{model.stu_id}"/></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><s:textfield name="stu_name"  value="%{model.stu_name}" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><s:radio cssStyle="height:15px; width:18px" name="stu_sex" list="{'男','女'}"  value="%{model.stu_sex}" /></td>
				</tr>
				<tr>
					<td>出生年月</td>
					<td><input type="text" name="stu_birth"  value="<s:date name="model.stu_birth" format="yyyy-MM-dd"/>" /></td>
				</tr>
				<tr>
					<td>籍贯地</td>
					<td><s:textfield name="stu_birthplace"  value="%{model.stu_birthplace}" /></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><s:textfield name="stu_email"  value="%{model.stu_email}" /></td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td><s:textfield name="stu_telephone"  value="%{model.stu_telephone}" /></td>
				</tr>
				<tr>
					<td>系别</td>
					<td><s:textfield name="dept_id"  value="%{model.dept_id}" /></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit cssClass="btn_submint" value="提交"/></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
