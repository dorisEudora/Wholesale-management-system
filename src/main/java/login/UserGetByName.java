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
 * Servlet implementation class UserGetByName
 */
@WebServlet("/UserGetByName")
public class UserGetByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserGetByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDB db = new UserDB();
		UserInfo user = new UserInfo();
		//1.��ȡ�ͻ��˴�������
		String name = MyTools.toChinese(request.getParameter("name"));
		//2.����
		user = db.GetUserbyName(name);
		//3.�ض���
		String str = "{";
		str+="\"id\":"+user.getUserId()+",\"name\":\""+user.getUserName()+"\",\"pwd\":\""+user.getUserPwd()+"\"}";
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(str);
		System.out.println("����getservlet");
		out.print(str);
		out.flush();
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
