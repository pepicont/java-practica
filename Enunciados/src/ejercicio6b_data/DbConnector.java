package ejercicio6b_data;

import java.sql.*;

public class DbConnector {
	
	private static DbConnector instancia;
	
	private String host="localhost";
	private String user="java";
	private String password="himitsu";
	private String db="java_market_b";
	private int conectados=0;
	private Connection conn=null;
	
	
	public static DbConnector getInstancia() {
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db, user, password);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
