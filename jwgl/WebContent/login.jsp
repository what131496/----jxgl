<%@ page language="java" import="org.apache.log4j.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path=request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head lang="en">
	<meta name="renderer" content="webkit" />
	<meta http-equiv="X-UA-Compatible" content="IE=9"/>
    <meta http-equiv="X-UA-Compatible" content="IE=10"/>
    <meta charset="UTF-8">
    <title>用户登录--甘肃农业大学教学管理系统登录</title>
    <link rel="shortcut icon" href="<%=path%>/front/img/icon.ico" />
    <link rel="stylesheet" href="<%=path%>/front/css/reset.css">
    <link rel=" stylesheet" href="<%=basePath%>front/css/main.css">
    </head>
    <Script>
		flag=<%="<s:actionmessage/>"%>;
		alert('获取的值'+flag);
		if(flag==0){
			alert('修改成功！');
		}
	</Script>
    <script type="text/javascript"> 
		function changeValidateCode(obj) { 
		//获取当前的时间作为参数，无具体意义 
		var timenow = new Date().getTime(); 
		//每次请求需要一个不同的参数，否则可能会返回同样的验证码 
		//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
		obj.src="rand.action?d="+timenow; 
		} 
	</script> 
    <style>
	.errorMessage{color:red;font-size:12px}	
	</style>
	<body background="<%=path%>/front/img/bg.jpg">
		<div class="logon-box">
			<h2>教学管理系统登录</h2>
			<div class="fl logon">
				<img src="<%=path%>/front/img/logon/1.png" alt="学生登录">
			</div>
			<s:form action="User_login" method="post" namespace="/">
				<h3 style="height:15px;display:block;margin-bottom:5px"><s:actionerror cssErrorStyle="font-size:14px;color:red"></s:actionerror></h3>
				<b class="paw">身 份</b><select style="width:210px" name="Role" >
					<option value="0">学生</option>
					<option value="1">教师</option>
					<option value="2">管理员</option>
				</select><br />
				<b>用户名</b><input type="text" name="UserId"  placeholder="请输入10位学号" maxlength="10" required="required" autocomplete="off"><br />
				<b class="paw">密 码</b><input type="password" placeholder="请输入您的密码"  name="UserPass" size="16" required="required" autocomplete="off">
				<a href="newPass.jsp" class="forget">忘记密码</a>
				<br />
				<b>验证码</b><input type="text" name="code" required="required" class="code" maxlength="4" autocomplete="off">
				<img style="margin:0 0 -9px 5px" src="Code.action" alt="验证码"><a href="" onclick="changeValidateCode(this)">看不清</a>
				<br />
				<input type="submit" value="登录" class="logon-btn">
				<input type="reset" value="重置" class="logon-btn">
			</s:form>
		</div>
	</body>
	<%
	String ip = request.getRemoteAddr();
  //取得日志记录器Logger
  Logger logger = Logger.getLogger(this.getClass());
  //使用日志记录器产生日志记录信息  logger.fatal("这是一条从index.jsp产生的fatal信息！");
  logger.fatal(ip+"   该地址用户访问了了本系统");
  logger.fatal("-----------------------------------------");
  %>
</html>
