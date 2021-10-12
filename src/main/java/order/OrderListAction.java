package order;

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
@WebServlet("/OrderListAction")
public class OrderListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderListAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDB db = new OrderDB();
		ArrayList<OrderInfo> orderList = new ArrayList<OrderInfo>();
		orderList = db.GetAllOrders();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String str = "[";
		for(int i = 0;i < orderList.size();i++) {
			OrderInfo order = orderList.get(i);
			str+="{\"id\":"+order.getId()+",\"no\":"+order.getNo()+",\"wno\":"+order.getWno()
				+",\"sno\":"+order.getSno()+",\"gno\":"+order.getGno()+",\"num\":"+order.getNum()+"}";
			if(i<orderList.size()-1) {
				str+=",";
			}
		}
		str+="]";
		System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
