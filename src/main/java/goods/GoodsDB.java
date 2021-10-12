package goods;
import java.sql.*;
import common.*;
import java.util.*;

public class GoodsDB {
	//��ȡָ����Ʒ��Ϣ
	public GoodsInfo GetGoodsbyId(int id) {
		GoodsInfo goods = null;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from t_goods where N_GOODS_ID=?");
			ps.setInt(1, id);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				goods = new GoodsInfo();
				goods.setId(rs.getInt("N_GOODS_ID"));
				goods.setSno(rs.getInt("N_GOODS_SNO"));
				goods.setName(rs.getString("VC_GOODS_NAME"));
				goods.setPsno(rs.getInt("N_SNO"));
				goods.setNum(rs.getInt("VC_GOODS_STOCK"));
			}
			rs.close();
			ps.close();			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("��ȡָ����Ʒʧ�ܣ�");
		}finally {
			DBConnection.closeConnection();
		}
		return goods;
	}
	//��ȡ������Ʒ��Ϣ
	public ArrayList<GoodsInfo> GetAllGoods() {
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		GoodsInfo goods = null;
			try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			Statement stm = con.createStatement();
			String sql = "select * from t_goods";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				goods = new GoodsInfo();
				goods.setId(rs.getInt("N_GOODS_ID"));
				goods.setSno(rs.getInt("N_GOODS_SNO"));
				goods.setName(rs.getString("VC_GOODS_NAME"));
				goods.setPsno(rs.getInt("N_SNO"));
				goods.setNum(rs.getInt("VC_GOODS_STOCK"));
				goodsList.add(goods);
			}	
			rs.close();
			stm.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("��ȡ������Ʒ��Ϣʧ�ܣ�");
		}finally {
			DBConnection.closeConnection();
		}	
		return goodsList;
	}
	//������Ʒ��Ϣ
	public int UpdateGoods(GoodsInfo goods) {		
		int count = 0;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			String sql="update t_goods set VC_GOODS_NAME=?,N_SNO=?,VC_GOODS_STOCK=? where N_GOODS_SNO=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setInt(2, goods.getPsno());
			ps.setInt(3, goods.getNum());
			ps.setInt(4, goods.getSno());
			count = ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("������Ʒ��Ϣ�ɹ���"+count);
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("������Ʒ��Ϣʧ�ܣ�"+e.getStackTrace());
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	//�����Ʒ��Ϣ
	public int InsertGoods(GoodsInfo goods) {		
		int count = 0;
		System.out.println(goods.getId());
		PreparedStatement ps = null;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into t_goods (N_GOODS_SNO,VC_GOODS_NAME,N_SNO,VC_GOODS_STOCK) values(?,?,?,?)");
			ps.setInt(1, goods.getSno());
			ps.setString(2, goods.getName());
			ps.setInt(3, goods.getPsno());
			ps.setInt(4, goods.getNum());
			count = ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("�����Ʒ��Ϣ�ɹ���");
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("�����Ʒ��Ϣʧ�ܣ�"+e.getMessage());
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	//ɾ����Ʒ��Ϣ
	public int DeleteGoodsById(int id) {		
		int count = 0;
		PreparedStatement ps = null;
		try {
			Connection con=DBConnection.getConnection();
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from t_goods where N_GOODS_ID=?");	
			ps.setInt(1, id);
			count = ps.executeUpdate();
			System.out.print(count);
			ps.close();
			con.close();
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("ɾ����Ʒ��Ϣʧ�ܣ�");
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
}
