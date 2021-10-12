package supplier;

import java.sql.*;
import java.util.*;
import common.DBConnection;

public class SupplierDB {
	/*��ȡ���й�������Ϣ*/
	private Connection con = null;
	public ArrayList<SupplierInfo> getAll(){
		ArrayList<SupplierInfo> supplierlist = new ArrayList<SupplierInfo>();
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery("select * from t_supplier");
			while(rs.next()) {
				SupplierInfo supplier = new SupplierInfo();
				supplier.setId(rs.getInt("N_ID"));
				supplier.setSno(rs.getInt("N_SNO"));
				supplier.setSname(rs.getString("VC_SNAME"));
				supplier.setTel(rs.getString("VC_TEL"));
				supplierlist.add(supplier);
				
			}
			rs.close();
			stm.close();
		}catch(Exception e) {
			System.out.println("��ȡ���й�������Ϣʧ��!");
		}finally {
			DBConnection.closeConnection();
		}
		return supplierlist;
	}
	
	/*��ӹ�������Ϣ*/
	public int insert(SupplierInfo supplier) {
		PreparedStatement pstm = null;
		int count = 0;
		try {
			con = DBConnection.getConnection();
			pstm = con.prepareStatement("insert into t_supplier (N_SNO,VC_SNAME,VC_TEL) value (?,?,?)");
			pstm.setInt(1,supplier.getSno());
			pstm.setString(2,supplier.getSname());
			pstm.setString(3,supplier.getTel());
			count = pstm.executeUpdate();
			pstm.close();
		}catch(Exception e) {
			System.out.println("��ӹ�������Ϣʧ��! " + e.getMessage());
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	
	/*��ȡָ����������Ϣ*/
	public SupplierInfo GetSupplierById(int id) {
		SupplierInfo supplier = new SupplierInfo();
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery("select * from t_supplier where N_ID=" + id);
			if(rs.next()) {
				supplier.setId(rs.getInt("N_ID"));
				supplier.setSno(rs.getInt("N_SNO"));
				supplier.setSname(rs.getString("VC_SNAME"));
				supplier.setTel(rs.getString("VC_TEL"));
			}
			rs.close();
			stm.close();
		}catch(Exception e) {
			System.out.println("��ȡָ����������Ϣʧ��! " + e.getMessage());
		}finally {
			DBConnection.closeConnection();
		}
		return supplier;
	}
	
	/*���½�ʦ��Ϣ*/
	public int update(SupplierInfo supplier) {
		PreparedStatement pstm = null;
		int count = 0;
		try {
			con = DBConnection.getConnection();
			pstm = con.prepareStatement("update t_supplier set N_SNO=?,VC_SNAME=?,VC_TEL=? where N_ID=?");
		    pstm.setInt(1,supplier.getSno());
		    pstm.setString(2,supplier.getSname());
		    pstm.setString(3,supplier.getTel());
		    pstm.setInt(4,supplier.getId());
		    count = pstm.executeUpdate();
		    pstm.close();
		}catch(Exception e) {
			System.out.println("���¹�������Ϣʧ�ܣ�"+e.getMessage());
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	
	/*ɾ����������Ϣ*/
    public int Delete(int id) {
    	int count = 0;
    	PreparedStatement pstm = null;
    	try {
    		con = DBConnection.getConnection();
    		pstm = con.prepareStatement("delete from t_supplier where N_ID=?");
    	    pstm.setInt(1,id);
    	    count = pstm.executeUpdate();
    	    pstm.close();
    	}catch(Exception e) {
    		System.out.println("ɾ����ʦ��Ϣʧ�ܣ�"+e.getMessage());
    	}finally {
    		DBConnection.closeConnection();
    	}
    	return count;
    }
}
