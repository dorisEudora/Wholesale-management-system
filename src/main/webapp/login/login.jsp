 
<%@ page contentType="text/html; charset=gb2312" %>
<script>
<%
String path = request.getContextPath();
String loginFlag=request.getParameter("loginflag");
String userName = (String)session.getAttribute("userName");
if(loginFlag==null){ //�޵�¼ʧ�ܱ�ʶ�����������ʵ�¼ҳ��
	loginFlag="";
}
if(loginFlag.equals("1")){
	out.println("alert('�û���"+userName+"�������ڣ�')");
}else if(loginFlag.equals("2")){
	out.println("alert('�������')");
}
%>
</script>
<html>
<link rel="stylesheet" type="text/css" href="../css/user.css"/>
<script type="text/javascript" src="../js/datacheck.js"></script>
	<body style="background-color:#eeeeee">
	<div style="background-color:#2B91D5;position:relative;padding-top:20px">
	<img src="../images/logo.jpg" style="width:120px;height:40px;position:absolute;left:10px;top:30%">
	<h1 style="text-align:center">��ţ��������ϵͳ</h1>
	<div style="background-color:black;width:100%;height:4px"></div>
	</div>		
	<center style="position:absolute;top:40%;z-index:1000;left:35%">
		<form name="frm" width="100" height="100" method="post" action="login_action.jsp">
			<table border="1">
				<tr><td colspan="5">�û���¼��Ϣ¼��<span class="star">*</span>Ϊ������</tr>
				<tr>
					<td>�û�����</td>
					<td><input type="text" value="" maxlength="20" name="name"></input><span class="star">*</span></td>
				</tr>
				<tr>
					<td>���룺</td>
					<td><input type="password" value="" maxlength="20" name="password"></input><span class="star">*</span></td>
				</tr>
				<tr>
					<td><input type="button" onclick="check()" value="�ύ"/></td>
					<td><input type="reset" value="����"/></td>
				</tr>
			</table>
		</form>
	</center>
	</body>
</html>
<script langage="JavaScript">
function check(){
	if(!frm.name.value){
		alert("�û�������Ϊ�գ�");
		frm.name.focus();
		return false
	}
	if(!frm.password.value){
		alert("���벻��Ϊ�գ�");
		frm.password.focus();
		return false
	}
	frm.submit();
}
</script>

