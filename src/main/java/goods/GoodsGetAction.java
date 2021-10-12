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
 * Servlet implementation class UserGetAction
 * 
 */
@WebServlet("/GoodsGetAction")
public class GoodsGetAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GoodsGetAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDB db = new GoodsDB();
		GoodsInfo goods = new GoodsInfo();
		//1.获取客户端传来数据
		int id = Integer.parseInt(request.getParameter("id"));
		//2.操作
		goods = db.GetGoodsbyId(id);
		//3.重定向
		String str = "{";
		str+="\"id\":"+goods.getId()+",\"sno\":"+goods.getSno()+",\"name\":\""+goods.getName()+"\",\"psno\":"+goods.getPsno()+",\"num\":"+goods.getNum()+"}";
		response.setContentType("application/json;charset=gb2312");
		PrintWriter out = response.getWriter();
		System.out.println(str);
		System.out.println("进入getservlet");
		out.print(str);
		out.flush();
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
