<%@page import="java.io.Console"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="login.*,common.*" %>

<%
request.setCharacterEncoding("gb2312"); 
String path = request.getContextPath();
//1、获取客户端提交数据
String userName = (String)request.getParameter("name");
String pwd = (String)request.getParameter("password");
UserInfo user = new UserInfo();

//2、处理客户端提交数据
UserDB db = new UserDB();
user = db.GetUserbyName(userName);
int flag=0;//登录成功0 用户不存在 1 密码错误 2

//通过查询数据库对比密码或者用户查看是否有这个用户判断是否登录成功
if(user == null){
	flag = 1;
}else if(!user.getUserPwd().toString().equals(pwd)){
	flag = 2;
}

//3、向客户端做出响应
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
