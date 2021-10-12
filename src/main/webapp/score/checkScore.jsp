<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	char[][] scoreList={{'1','2'},{'2','2'},{'3','3'}};			//创建一个二维数组
	String score=new String(request.getParameter("sid").getBytes("ISO-8859-1"),"UTF-8");	//获取sid
	score+=request.getParameter("cid").getBytes("ISO-8859-1");	//获取cid
	Arrays.sort(scoreList);									//对数组排序	
	int result=Arrays.binarySearch(scoreList,score);				//搜索数组
	if(result>-1){
		out.println("很抱歉，该学生的该课程成绩已录入！");			//输出检测结果
	}else{
		out.println("恭喜您，该学生的该课程成绩未录入！");			//输出检测结果
	}
%>
