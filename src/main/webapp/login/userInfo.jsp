<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=GB2312"  %>
<%@ page import="login.*,common.*" %>
<% request.setCharacterEncoding("gb2312");
String path = request.getContextPath();
ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
String userName = (String)session.getAttribute("userName");
Boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
if(userName != null){	
	out.print("�û�"+session.getAttribute("userName")+"�ɹ���¼");	
	if(isAdmin){
		response.sendRedirect(path+"/login/user.html");
	}
}else{
	out.print("���ȵ�¼��");
	response.sendRedirect(path+"/login/login.jsp");
}

%>