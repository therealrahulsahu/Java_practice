package com.database;
import java.sql.*;

public class MySQLTool {
	Connection conn = null;
	Statement stmt = null;
	ResultSet result = null;
	boolean result_available = false;
	String S_driver = "com.mysql.cj.jdbc.Driver";
	String S_url = "jdbc:mysql://localhost:3306/project";
	String S_user = "root";
	String S_password = "";

	public MySQLTool(String url, String user, String password){  //constructor to store user-configuration
		S_url = url;
		S_user = user;
		S_password = password;
	}

	public void insert_query(String query){
		result_available = false;
		try {
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	void close(){
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException ignored){
		}
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
}
