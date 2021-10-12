package order;
import java.sql.*;
import common.*;
import java.util.*;

public class OrderDB {
	//��ȡָ��������Ϣ
	public OrderInfo GetOrderbyId(int id) {
		OrderInfo order = null;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from db_order.t_order where N_ORDER_ID=?");
			ps.setInt(1, id);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new OrderInfo();
				order.setId(rs.getInt("N_ORDER_ID"));
				order.setNo(rs.getInt("N_ORDER_SNO"));
				order.setWno(rs.getInt("N_WNO"));
				order.setSno(rs.getInt("N_SNO"));
				order.setGno(rs.getInt("N_GOODS_NO"));
				order.setNum(rs.getInt("N_GOODS_NUM"));
			}
			rs.close();
			ps.close();			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("��ȡָ������ʧ�ܣ�");
		}finally {
			DBConnection.closeConnection();
		}
		return order;
	}
	//��ȡ���ж�����Ϣ
	public ArrayList<OrderInfo> GetAllOrders() {
		ArrayList<OrderInfo> orderList = new ArrayList<OrderInfo>();
		OrderInfo order = null;
			try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			Statement stm = con.createStatement();
			String sql = "select * from t_order";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				order = new OrderInfo();
				order.setId(rs.getInt("N_ORDER_ID"));
				order.setNo(rs.getInt("N_ORDER_SNO"));
				order.setWno(rs.getInt("N_WNO"));
				order.setSno(rs.getInt("N_SNO"));
				order.setGno(rs.getInt("N_GOODS_NO"));
				order.setNum(rs.getInt("N_GOODS_NUM"));
				orderList.add(order);
			}	
			rs.close();
			stm.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("��ȡ���ж�����Ϣʧ�ܣ�");
		}finally {
			DBConnection.closeConnection();
		}	
		return orderList;
	}
	//���¶�����Ϣ
	public int UpdateOrder(OrderInfo order) {		
		int count = 0;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			String sql="update t_order set N_WNO=?,N_SNO=?,N_GOODS_NO=?,N_GOODS_NUM=? where N_ORDER_SNO=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, order.getWno());
			ps.setInt(2, order.getSno());
			ps.setInt(3, order.getGno());
			ps.setInt(4, order.getNum());
			ps.setInt(5, order.getNo());
			count = ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("���¶�����Ϣ�ɹ���"+count);
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("���¶�����Ϣʧ�ܣ�"+e.getStackTrace());
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	//��Ӷ�����Ϣ
	public int InsertOrder(OrderInfo order) {		
		int count = 0;
		System.out.println(order.getId());
		PreparedStatement ps = null;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into t_order (N_ORDER_SNO,N_WNO,N_SNO,N_GOODS_NO,N_GOODS_NUM) values(?,?,?,?,?)");
			ps.setInt(1, order.getNo());
			ps.setInt(2, order.getWno());
			ps.setInt(3, order.getSno());
			ps.setInt(4, order.getGno());
			ps.setInt(5, order.getNum());
			count = ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("��Ӷ�����Ϣ�ɹ���");
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("��Ӷ�����Ϣʧ�ܣ�"+e.getMessage());
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	//ɾ��������Ϣ
	public int DeleteOrderById(int id) {		
		int count = 0;
		PreparedStatement ps = null;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from t_order where N_ORDER_ID=?");	
			ps.setInt(1, id);
			count = ps.executeUpdate();
			System.out.print(count);
			ps.close();
			con.close();
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("ɾ��������Ϣʧ�ܣ�");
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
}
