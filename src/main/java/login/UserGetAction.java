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
 * Servlet implementation class UserGetAction
 * 
 */
@WebServlet("/UserGetAction")
public class UserGetAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserGetAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDB db = new UserDB();
		UserInfo user = new UserInfo();
		//1.获取客户端传来数据
		int id = Integer.parseInt(request.getParameter("id"));
		//2.操作
		user = db.GetUserbyId(id);
		//3.重定向
		String str = "{";
		str+="\"id\":"+user.getUserId()+",\"name\":\""+user.getUserName()+"\",\"pwd\":\""+user.getUserPwd()+"\"}";
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(str);
		System.out.println("进入getservlet");
		out.print(str);
		out.flush();
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
