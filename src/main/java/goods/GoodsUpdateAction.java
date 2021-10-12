package goods;

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
@WebServlet("/GoodsUpdateAction")
public class GoodsUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GoodsUpdateAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDB db = new GoodsDB();
		GoodsInfo goods = new GoodsInfo();
		goods.setId(MyTools.strToint(request.getParameter("id")));
		goods.setSno(MyTools.strToint(request.getParameter("sno")));
		goods.setName(request.getParameter("name"));
		goods.setPsno(MyTools.strToint(request.getParameter("psno")));
		goods.setNum(MyTools.strToint(request.getParameter("num")));
		System.out.println("id="+goods.getId()+" sno="+goods.getSno()+" name="+goods.getName()+" psno="+goods.getPsno()+" num="+goods.getNum());
		int count = 0;
		if(goods.getId() == -1) {
			count = db.InsertGoods(goods);
		}else {
			count = db.UpdateGoods(goods);
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
