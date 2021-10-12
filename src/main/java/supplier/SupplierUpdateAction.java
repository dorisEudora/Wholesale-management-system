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
 * Servlet implementation class SupplierUpdateAction
 */
@WebServlet("/SupplierUpdateAction")
public class SupplierUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SupplierDB db = new SupplierDB();
		//1.获取客户端请求
		SupplierInfo supplier = new SupplierInfo();
		supplier.setId(MyTools.strToint(request.getParameter("Id")));
		supplier.setSno(MyTools.strToint(request.getParameter("Sno")));
		supplier.setSname(request.getParameter("Sname"));
		supplier.setTel(request.getParameter("Tel"));
		System.out.println("id=" + supplier.getId() + "name=" + supplier.getSname());
		//2、进行数据处理
		int count = 0;
		if(supplier.getId() == -1) {
			count=db.insert(supplier); 
		}else {
			count=db.update(supplier); 
		}
		 //3、向客户端做出响应
		response.setContentType("text/html;charset=UTF-8");//返回text 
		PrintWriter out = response.getWriter();
		if(count != 0){    
			   out.print("1");  
		}else{   
			out.print("0");  
		}
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
