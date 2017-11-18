<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@ taglib uri="/struts-dojo-tags" prefix="sx"  %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	Date d = new Date();  
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	String now= sdf.format(d); 
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=path%>/front/css/main.css" />
		<sx:head />
	</head>
	<style>
	  .datatable tr:hover,.datatable tr.hilite
	    {
	    background-color:rgba(2,146,172,0.5);
	    
		 }
		 table tr td{height: 25px;}
		 
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
		<s:form id="saveForm" action="outSchool_save" method="post"
		namespace="/" theme="simple">
			<table class="datatable" border="1" width="680">
				<tr class="tableTiltle">
					<td colspan="2">信息科学技术学院公休日、节假日离校外出登记（请谨慎填写，不允许修改！！）</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><s:textfield name="name"  /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><s:radio cssStyle="height:15px; width:18px" name="sex" list="{'男','女'}"/></td>
				</tr>
				<tr>
					<td>手机</td>
					<td><input type="text" name="phone"  /></td>
				</tr>
				<tr>
					<td>离校事由</td>
					<td><s:textfield name="reason"  /></td>
				</tr>
				<tr>
					<td>出行目的地</td>
					<td><s:textfield name="place"  /></td>
				</tr>
				<tr>
					<td>备用联系人姓名</td>
					<td><s:textfield name="your_phone"   /></td>
				</tr>
				<tr>
					<td>与本人关系</td>
					<td><s:textfield name="relationship"   /></td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td><s:textfield name="re_phone"   /></td>
				</tr>
				<tr>
					<td>离校时间</td>
					<td><input id="meeting" name="leave_time" type="date" value="<%=now%>"/></td>
				</tr>
				<tr>
					<td>返校时间</td>
					<td><input id="meeting" name="back_time" type="date" value="<%=now%>"/></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit cssClass="btn_submint" value="提交"/></td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>
