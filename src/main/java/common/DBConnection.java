package common;
import java.sql.*;

public class DBConnection {
	static Connection con=null;
	/**��ȡ���ݿ�����*/
	public static Connection getConnection(){
		if(con==null){
			try { //������������
				Class.forName("com.mysql.cj.jdbc.Driver");
		    }catch(Exception e){ 
	    		e.printStackTrace();
	    		System.out.println("����MYSQL���ݿ�����ʧ�ܣ�");
		    }
		    try { //ͨ�����������������ȡ���ݿ�����
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_student?characterEncoding=UTF-8&serverTimezone=UTC",
		    			"root","007580");
		    }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
		    }
		}
	    return con;
	}
    /** �ر����ݿ�Ĳ��� */
    public static void closeConnection() {
     	if(con!=null)
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�con����ʧ�ܣ�");
			}
    }

}