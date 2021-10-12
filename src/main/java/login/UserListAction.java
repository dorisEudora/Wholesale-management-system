package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserListAction
 * 
 */
@WebServlet("/UserListAction")
public class UserListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserListAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDB db = new UserDB();
		ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
		userList = db.GetUserListbyName("admin");
		String str = "[";
		for(int i = 0;i < userList.size();i++) {
			UserInfo user = userList.get(i);
			str+="{\"id\":"+user.getUserId()+",\"name\":\""+user.getUserName()+"\",\"pwd\":\""+user.getUserPwd()+"\"}";
			if(i<userList.size()-1) {
				str+=",";
			}
		}
		str+="]";
		System.out.println(str);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
