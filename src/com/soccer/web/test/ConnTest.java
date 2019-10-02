package com.soccer.web.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.soccer.web.domains.PlayerBean;

public class ConnTest {
	public static void main(String[] args) {
		
		PlayerBean pb;
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe", 
				userName="c##bit", passWord="bitcamp";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, userName, passWord);
			if (conn != null) {
				System.out.println("연결성공");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT DISTINCT (NVL(POSITION,'')) position\r\n" + 
						"FROM PLAYER");
				String position = "";
				while (rs.next()) {
					position = rs.getString("position");
					System.out.println( "position :  " + position );
				}

				
			}else {
				System.out.println("연결 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
