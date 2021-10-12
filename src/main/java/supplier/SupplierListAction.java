package supplier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SupplierListAction
 */
@WebServlet("/SupplierListAction")
public class SupplierListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SupplierDB db = new SupplierDB();
		ArrayList<SupplierInfo> list = db.getAll();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String jsonStr="[";
		for(int i=0;i<list.size();i++) {
			SupplierInfo supplier=list.get(i);
			jsonStr+="{\"Id\":"+supplier.getId()+",\"Sno\":"+supplier.getSno()+",\"Sname\":\""+supplier.getSname()+"\",";
			jsonStr+="\"Tel\":"+supplier.getTel()+"}";
		    if(i<list.size()-1) {
		    	jsonStr+=",";
		    }
		}
		jsonStr+="]";
		System.out.println(jsonStr);
		out.println(jsonStr);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
