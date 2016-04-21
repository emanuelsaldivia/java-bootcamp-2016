package topic0.AbstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private String dbDriver="com.mysql.jdbc.Driver";
	private static String user="root";
	private static String pass="abc123";
	private static String dbname = "mysqldb";
	private Connection conn;
	private static MySQLConnection instance;

	MySQLConnection(){
		try {
			Class.forName(dbDriver);
			conn = null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MySQLConnection getInstance() {
		if(instance==null) instance = new MySQLConnection();
		return instance;
	}
	
	//@Override
	public Connection getConnection() {
		try {
			if(conn==null || conn.isClosed())
				conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbname, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//@Override
	public void releaseConnection() {
		try {
			if(!conn.isClosed()) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}