package goods;

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
@WebServlet("/GoodsListAction")
public class GoodsListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GoodsListAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDB db = new GoodsDB();
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		goodsList = db.GetAllGoods();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String str = "[";
		for(int i = 0;i < goodsList.size();i++) {
			GoodsInfo goods = goodsList.get(i);
			str+="{\"id\":"+goods.getId()+",\"sno\":"+goods.getSno()+",\"name\":\""+goods.getName()+"\",\"psno\":"+goods.getPsno()+",\"num\":"+goods.getNum()+"}";
			if(i<goodsList.size()-1) {
				str+=",";
			}
		}
		str+="]";
		System.out.println(str);
		out.println(str);
		out.flush();
		out.close();//关闭输出流对象
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
