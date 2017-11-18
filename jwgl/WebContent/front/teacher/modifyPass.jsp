<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=path%>/front/css/main.css" />
	</head>
	<style>
	
		 table tr td{height: 58px; width:230px}
		 .info input{height: 56px; border: none; outline: none; width:250px;text-indent: 10px;}
	</style>
	<script>
		function check(){
			var confirm=document.getElementById('confirm');
			var newPass=document.getElementById('newPass');
			var infom=document.getElementById('infom');
			var actionError=document.getElementById('actionError');
			if(confirm.value!=newPass.value){
				infom.innerHTML='两次输入密码不一致';
				return false;
			}
			if(actionError.value!=null){
				infom.innerHTML=" ";
			}
			return true;
		}
	</script>
	<body>
		<div class="info">
		  <s:form action="modify_editTeachers" method="post" namesapce="/">
			<table class="datatable" border="1" width="380">
				<tr>
					<td>提示</td>
					<td><b id="infom" style="color:red">正确输入旧密码</b><s:actionerror id="actionError" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>旧密码</td>
					<td><input required="required" type="password" name="oldPass" ></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input required="required" id="newPass" type="password" name="newPass" ></td>
				</tr>
				<tr>
					<td>确认新密码</td>
					<td><input required="required" id="confirm" type="password" name="confirmPass" ></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn_submint" type="submit" onclick="return check()" value="提交" ></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
