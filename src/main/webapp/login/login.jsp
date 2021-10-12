 
<%@ page contentType="text/html; charset=gb2312" %>
<script>
<%
String path = request.getContextPath();
String loginFlag=request.getParameter("loginflag");
String userName = (String)session.getAttribute("userName");
if(loginFlag==null){ //无登录失败标识，是正常访问登录页面
	loginFlag="";
}
if(loginFlag.equals("1")){
	out.println("alert('用户【"+userName+"】不存在！')");
}else if(loginFlag.equals("2")){
	out.println("alert('密码错误！')");
}
%>
</script>
<html>
<link rel="stylesheet" type="text/css" href="../css/user.css"/>
<script type="text/javascript" src="../js/datacheck.js"></script>
	<body style="background-color:#eeeeee">
	<div style="background-color:#2B91D5;position:relative;padding-top:20px">
	<img src="../images/logo.jpg" style="width:120px;height:40px;position:absolute;left:10px;top:30%">
	<h1 style="text-align:center">皇牛批发管理系统</h1>
	<div style="background-color:black;width:100%;height:4px"></div>
	</div>		
	<center style="position:absolute;top:40%;z-index:1000;left:35%">
		<form name="frm" width="100" height="100" method="post" action="login_action.jsp">
			<table border="1">
				<tr><td colspan="5">用户登录信息录入<span class="star">*</span>为必填项</tr>
				<tr>
					<td>用户名：</td>
					<td><input type="text" value="" maxlength="20" name="name"></input><span class="star">*</span></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" value="" maxlength="20" name="password"></input><span class="star">*</span></td>
				</tr>
				<tr>
					<td><input type="button" onclick="check()" value="提交"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
	</center>
	</body>
</html>
<script langage="JavaScript">
function check(){
	if(!frm.name.value){
		alert("用户名不能为空！");
		frm.name.focus();
		return false
	}
	if(!frm.password.value){
		alert("密码不能为空！");
		frm.password.focus();
		return false
	}
	frm.submit();
}
</script>

