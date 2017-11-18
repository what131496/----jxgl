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
		<s:form id="saveForm" action="User_update" method="post"
		namespace="/" theme="simple">
			<table class="datatable" border="1" width="680">
			
				<tr>
					<td>用户编号</td>
					<td><s:textfield name="UserId" readonly="true" required="required" value="%{model.UserId}"/></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><s:textfield name="UserName" required="required" value="%{model.UserName}"/></td>
				</tr>
				<tr>
					<td>密 码</td>
					<td><s:textfield name="UserPass" required="required"  value="%{model.UserPass}" /></td>
				</tr>
				<tr>
					<td>角 色</td>
					<td><s:textfield name="Role" required="required" placeholder="0是学生，1是教师，2是管理员"  value="%{model.Role}" /></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit cssClass="btn_submint" value="提交"/></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
