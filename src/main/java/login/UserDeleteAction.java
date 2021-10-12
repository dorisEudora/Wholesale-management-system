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
 * Servlet implementation class UserDeleteAction
 * 
 */
@WebServlet("/UserDeleteAction")
public class UserDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDB db = new UserDB();
			int id = MyTools.strToint(request.getParameter("id"));			
			int count = db.DeleteById(id);
			response.setContentType("application/json;charset=UFT-8");
			PrintWriter out = response.getWriter();
			if(count == 0) {
				out.print(0);
			}else {
				out.print(1);
			}
			out.flush();
			out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
