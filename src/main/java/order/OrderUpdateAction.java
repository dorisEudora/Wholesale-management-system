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
 * Servlet implementation class UserUpdateAction
 * 
 */
@WebServlet("/OrderUpdateAction")
public class OrderUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderUpdateAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDB db = new OrderDB();
		OrderInfo order = new OrderInfo();
		order.setId(MyTools.strToint(request.getParameter("id")));
		order.setNo(MyTools.strToint(request.getParameter("no")));
		order.setWno(MyTools.strToint(request.getParameter("wno")));
		order.setSno(MyTools.strToint(request.getParameter("sno")));
		order.setGno(MyTools.strToint(request.getParameter("gno")));
		order.setNum(MyTools.strToint(request.getParameter("num")));
		System.out.println("id="+order.getId()+" no="+order.getNo()+" wno="+order.getWno()+" sno="+order.getSno()+" gno="+order.getGno()+" num="+order.getNum());
		int count = 0;
		if(order.getId() == -1) {
			count = db.InsertOrder(order);
		}else {
			count = db.UpdateOrder(order);
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
