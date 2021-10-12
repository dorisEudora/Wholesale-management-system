package supplier;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.MyTools;


/**
 * Servlet implementation class SupplierGetAction
 */
@WebServlet("/SupplierGetAction")
public class SupplierGetAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierGetAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = MyTools.strToint(request.getParameter("Id"));
		SupplierDB db = new SupplierDB();
		SupplierInfo supplier=db.GetSupplierById(id);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String jsonStr="";
		jsonStr+="{\"Id\":"+supplier.getId()+",\"Sno\":"+supplier.getSno()+",\"Sname\":\""+supplier.getSname()+"\",";
		jsonStr+="\"Tel\":"+supplier.getTel()+"}";
		System.out.println(jsonStr);
		out.print(jsonStr);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
