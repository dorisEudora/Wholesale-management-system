package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class UserUpdateAction
 * 
 */
@WebServlet("/UserUpdateAction")
public class UserUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserUpdateAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDB db = new UserDB();
		UserInfo user = new UserInfo();
		user.setUserId(MyTools.strToint(request.getParameter("id")));
		user.setUserName(MyTools.toChinese(request.getParameter("name")));
		user.setUserPwd(MyTools.toChinese(request.getParameter("pwd")));
		int count = 0;
		if(user.getUserId() == -1) {
			count = db.InsertUser(user);
		}else {
			count = db.UpdateUser(user);
		}
		//3、向客户端做出响应
		response.setContentType("text/html;charset=UTF-8");	//返回text 
		PrintWriter out = response.getWriter();	
		if(count != 0) {
			out.print("1");
		}else {
			out.print("0");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
