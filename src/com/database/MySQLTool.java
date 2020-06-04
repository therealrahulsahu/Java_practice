package com.database;
import java.sql.*;
import java.util.ArrayList;

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

	public void insert_query(String query){				// function execute a insert query
		result_available = false;
		try {
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
	}

	public void insert_multiple_queries(ArrayList<String> queries){		// function to execute multiple insert queries
		result_available = false;
		try {
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			for (String query: queries) {
				stmt.executeUpdate(query);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
	}
	void close(){				// method to close connection
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException ignored){
		}
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			System.out.println(se.toString());
		}
	}
}
