package com.dps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	public static Connection getConn() {
		String url="jdbc:mysql://127.0.0.1/sms";
		Connection conn=null;
		
		try {
			conn= DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		
		
		
		
		
	}

}
