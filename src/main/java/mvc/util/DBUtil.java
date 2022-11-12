package mvc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	private static DataSource ds;


	static {
		try {
			Context initContext = new InitialContext();
			/*
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	 
			 */
			ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// static
	

	public static Connection getConnection() throws SQLException {
		Connection conn = ds.getConnection();
		return conn;
	}
	
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			dbClose(con, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void dbClose(Connection con, Statement st) {
		try {
			if(st!=null) st.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
