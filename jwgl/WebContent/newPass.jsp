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
	<script>
		flag=<%="<s:actionmessage/>"%>;
		alert(flag+"12121");
		if(flag==0){
			alert('修改成功！');
		}
	</script>
	<style>
		 table tr td{height: 35px; width:230px}
		 .forget{margin:120px auto}
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
		<div class="info forget">
		  <form action="modify_edit" method="post">
			<table class="datatable" border="1" width="780">
				<tr class="tableTiltle">
					<td>温馨提示：</td>
					<td><b id="infom" style="color:red">设置新的密码，请牢记！</b><s:actionerror id="actionError" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>您的学号</td>
					<td><input required="required" type="text" name="Id" placeholder="登陆时候的证件号"></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input required="required" id="newPass" type="text" name="newPass" ></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input required="required" id="confirm" type="text" name="confirmPass"></td>
				</tr>
				<tr>
					<td colspan="2" ><input onclick="return check()" class="btn_submint" type="submit"  value="确定提交"></td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>
