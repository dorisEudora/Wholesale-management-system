<%@page import="java.io.Console"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="login.*,common.*" %>

<%
request.setCharacterEncoding("gb2312"); 
String path = request.getContextPath();
//1����ȡ�ͻ����ύ����
String userName = (String)request.getParameter("name");
String pwd = (String)request.getParameter("password");
UserInfo user = new UserInfo();

//2������ͻ����ύ����
UserDB db = new UserDB();
user = db.GetUserbyName(userName);
int flag=0;//��¼�ɹ�0 �û������� 1 ������� 2

//ͨ����ѯ���ݿ�Ա���������û��鿴�Ƿ�������û��ж��Ƿ��¼�ɹ�
if(user == null){
	flag = 1;
}else if(!user.getUserPwd().toString().equals(pwd)){
	flag = 2;
}

//3����ͻ���������Ӧ
if(flag==0){
	session.setAttribute("userName",userName);
	if(userName.equals("admin")){
		session.setAttribute("isAdmin", true);
		//response.sendRedirect(path+"/login/user.html");
	}else{
		session.setAttribute("isAdmin", false);
		//response.sendRedirect(path+"/login/userInfo.jsp");
	}
	response.sendRedirect(path+"/broad.html");
}else{
	session.setAttribute("userName",userName);
	response.sendRedirect(path+"/login/login.jsp?loginflag="+flag);
}
%>
