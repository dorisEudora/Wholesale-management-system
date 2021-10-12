package login;
import java.sql.*;
import common.*;
import java.util.*;
public class UserDB {
	private Connection con = null;
	public UserInfo GetUserbyName(String name) {
		UserInfo user = null;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from t_user where VC_LOGIN_NAME=?");
			ps.setString(1, name);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new UserInfo();
				user.setUserId(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
			}
			rs.close();
			ps.close();			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("获取指定用户失败！");
		}finally {
			DBConnection.closeConnection();
		}
		return user;
	}
	public UserInfo GetUserbyId(int id) {
		UserInfo user = null;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from t_user where N_USER_ID=?");
			ps.setInt(1, id);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new UserInfo();
				user.setUserId(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
			}
			rs.close();
			ps.close();			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("获取指定用户失败！");
		}finally {
			DBConnection.closeConnection();
		}
		return user;
	}
	public ArrayList<UserInfo> GetUserListbyName(String userName) {
		ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
		UserInfo user = null;
		if(userName.equals("admin")) {
			try {
			con = DBConnection.getConnection();
			Statement stm = con.createStatement();
			String sql = "select * from t_user";
			ResultSet rs = stm.executeQuery(sql);			
			while(rs.next()) {
				user = new UserInfo();
				user.setUserId(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
				userList.add(user);
			}			
			rs.close();
			stm.close();			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("获取所有用户失败！");
		}finally {
			DBConnection.closeConnection();
		}
		}		
		return userList;
	}
	public int UpdateUser(UserInfo user) {		
		int count = 0;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("update t_user set VC_LOGIN_NAME=?,VC_PASSWORD=? where N_USER_ID=?");
			ps.setInt(3, user.getUserId());
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPwd());
			count = ps.executeUpdate();
			ps.close();
			con.close();
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("更新用户失败！");
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	public int InsertUser(UserInfo user) {		
		int count = 0;
		System.out.println(user.getUserId());
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into t_user (VC_LOGIN_NAME,VC_PASSWORD) values(?,?)");
			//ps.setInt(1, user.getUserId());
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPwd());
			count = ps.executeUpdate();
			ps.close();
			con.close();
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("新增用户失败！");
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
	public int DeleteById(int id) {		
		int count = 0;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from t_user where N_USER_ID=?");	
			ps.setInt(1, id);
			count = ps.executeUpdate();
			System.out.print(count);
			ps.close();
			con.close();
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("删除用户失败！");
		}finally {
			DBConnection.closeConnection();
		}
		return count;
	}
}
