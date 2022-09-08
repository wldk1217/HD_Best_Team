package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.kosa.dbUtil.DBConnection;

public class MemberDAO {
	
	public static void main(String[] args) {
		System.out.println("test");
		Scanner sc = new Scanner(System.in);

		System.out.print("회원ID: ");
		String id = sc.next();	
		System.out.print("pw: ");
		String pw = sc.next();
		System.out.print("name 입력: ");
		String name = sc.next();
		System.out.print("tel 입력: ");
		String tel = sc.next();
		System.out.print("birth 입력: ");
		String birth = sc.next();
		System.out.print("email 입력: ");
		String email = sc.next();
		System.out.print("gender 입력: ");
		int gender = sc.nextInt();
		System.out.print("nick 입력: ");
		String nick = sc.next();
		System.out.print("addrress 입력: ");
		String addrress = sc.next();
		
		String runSP = "{ call member_insert(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, id);
			callableStatement.setString(2, pw);
			callableStatement.setString(3, name);
			callableStatement.setString(4, tel);
			callableStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			callableStatement.setString(6, email);
			callableStatement.setInt(7, gender);
			callableStatement.setString(8, nick);
			callableStatement.setString(9, addrress);
			
			callableStatement.executeUpdate();	
			System.out.println("성공");			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
}
