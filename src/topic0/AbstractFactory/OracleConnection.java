package topic0.AbstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection extends SQL {

	private static String user="root";
	private static String pass="abc123";
	private static String dbname = "oracledb";
	private String dbDriver="com.oracle.jdbc.Driver";
	private Connection connection;
	private static OracleConnection instance;

	private OracleConnection(){
		try {
			Class.forName(dbDriver);
			connection = null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static OracleConnection getInstance() {
		if(instance==null) instance = new OracleConnection();
		return instance;
	}
	
	public Connection getConnection() {
		try {
			if(connection==null || connection.isClosed())
				connection = DriverManager.getConnection("jdbc:oracle://localhost/" + dbname, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void releaseConnection() {
		try {
			if(!connection.isClosed()) connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
