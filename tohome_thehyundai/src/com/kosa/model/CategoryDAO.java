package com.kosa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosa.dbUtil.DBConnection;
import com.kosa.dbUtil.DbUtil;

public class CategoryDAO {
	
	public static void main(String[] args) {
		System.out.println("test");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		conn = DBConnection.getConnection();
		try {
			int a = 0;
			String b = null;

			
			
			System.out.println("connection successful");
			stmt = conn.prepareStatement("select * from v_category");

			rs = stmt.executeQuery();

			while (rs.next()) {
				a = rs.getInt(1);
				b = rs.getString(2);
				System.out.println(a + " " + b);
			}

			rs.close();
			stmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}