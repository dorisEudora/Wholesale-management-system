package order;

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
@WebServlet("/OrderGetAction")
public class OrderGetAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderGetAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDB db = new OrderDB();
		OrderInfo order = new OrderInfo();
		//1.获取客户端传来的数据
		int id = Integer.parseInt(request.getParameter("id"));
		//2.操作
		order = db.GetOrderbyId(id);
		//3.重定向
		String str = "{";
		str+="\"id\":"+order.getId()+",\"no\":"+order.getNo()+",\"wno\":"+order.getWno()+",\"sno\":"+order.getSno()+",\"gno\":"+order.getGno()+",\"num\":"+order.getNum()+"}";
		response.setContentType("application/json;charset=gb2312");
		PrintWriter out = response.getWriter();
		System.out.println(str);
		System.out.println("进入OrderGetAction getservlet");
		out.print(str);
		out.flush();
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
