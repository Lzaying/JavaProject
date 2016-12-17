package team.sqjj.hospital.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	protected static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	protected static String dbUrl = "jdbc:sqlserver://localhost:1433;"
			+ "DatabaseName=db_library;SelectMethod=Cursor";
	protected static String dbUser = "sa";
	protected static String dbPwd = "";
	protected static String second = null;
	private static Connection conn = null;
	
	protected Dao() {
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
			else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}
	protected static ResultSet executeQuery(String sql) {
		try {
			if(conn==null)
			new Dao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}
	protected static int executeUpdate(String sql) {
		
		try {
			if(conn==null)
				new Dao();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//if(e.getMessage().equals("[Microsoft][SQLServer 2000 Driver for JDBC][SQLServer]DELETE ����� COLUMN REFERENCE Լ�� 'FK_TB_BORRO_REFERENCE_TB_BOOKI' ��ͻ���ó�ͻ���������ݿ� 'db_library'���� 'tb_borrow', column 'bookISBN'��"))
				
			return -1;
		} finally {
		}
	}
	
	protected static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
