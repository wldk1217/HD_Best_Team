package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import com.kosa.dbUtil.DBConnection;
import com.kosa.entity.MemberVO;

import oracle.jdbc.OracleTypes;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public MemberDAO() {

	}

	public static MemberDAO getInstance() {
		return instance;
	}

	/* MemberDAO 테스트시 사용 */

//	public static void main(String[] args) {
//		MemberDAO dao = MemberDAO.getInstance();
//		dao.updateMember("admin12", "1234", "010-1234-1234", "admin12@naver.com", "서울특별시 종로구 코코레지던스 308호");
//		MemberVO vo = dao.selectMember("admin12");
//		
//		System.out.println(vo.getMemberId());
//		System.out.println(vo.getMemberName());

//		dao.deleteMember("asd");
//		System.out.println(dao.passwordCheck("admin12", "0"));
//	}

	public MemberVO selectMember(String memberID) {
		MemberVO memberVO = new MemberVO();
		String run = "{call MEMBER_SELECT(?,?)}";
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberID);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {

					memberVO.setMemberName(resultSet.getString(1));
					memberVO.setMemberId(resultSet.getString(2));
					memberVO.setMemberPw(resultSet.getString(3));
					memberVO.setMemberTel(resultSet.getString(4));
					memberVO.setMemberEmail(resultSet.getString(5));
					memberVO.setMemberAdderss(resultSet.getString(6));
				}

				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberVO;
	}

	public MemberVO loginCheck(String memberID, String memberPW) {

		System.out.println("loginCheck 여기왔다");

		MemberVO memberVO = new MemberVO();
		String run = "{call MEMBER_LOGINCHECK(?,?,?)}";
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberID);
			callableStatement.setString(2, memberPW);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(3);

				while (resultSet.next()) {
					memberVO.setMemberId(resultSet.getString(1));
					memberVO.setMemberPw(resultSet.getString(2));
				}

				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberVO;
	}

	public int insertMember(MemberVO memberVO) {
		System.out.println("insertMember 여기왔다");

		int result = 0;
		String runSP = "{ call member_insert(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement cs = conn.prepareCall(runSP);

			cs.setString(1, memberVO.getMemberId());
			cs.setString(2, memberVO.getMemberPw());
			cs.setString(3, memberVO.getMemberName());
			cs.setString(4, memberVO.getMemberTel());
			cs.setString(5, memberVO.getMemberBirth());
			cs.setString(6, memberVO.getMemberEmail());
			cs.setInt(7, memberVO.getMemberGender());
			cs.setString(8, memberVO.getMemberNickname());
			cs.setString(9, memberVO.getMemberAdderss());

			result = cs.executeUpdate();

			System.out.println("성공");

		} catch (SQLException e) {
			System.out.println("프로시저에서 에러 발생!");
			// System.err.format("SQL State: %s", e.getSQLState());
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public MemberVO idCheck(String memberID) {

		System.out.println("idCheck 여기왔다");

		MemberVO memberVO = new MemberVO();
		String run = "{call MEMBER_CHECKID(?,?)}";
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberID);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {
					memberVO.setMemberId(resultSet.getString(1));
				}

				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberVO;
	}

	// 아이디 찾기
	public String findID(String memberName, String memberEmail) {
		String result = "";
		String sql = "select memberId from member where memberName=? and memberEmail = ?";

		try {
			Connection connn = DBConnection.getConnection();
			PreparedStatement pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberEmail);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("memberId");
			} else {
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 비밀번호 찾기
	public String findPW(String memberId, String memberEmail, String memberTel) {
		String result = "";
		String sql = "select memberPw from member where memberId=? and memberEmail=? and memberTel=?";

		try {
			Connection connn = DBConnection.getConnection();
			PreparedStatement pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberEmail);
			pstmt.setString(3, memberTel);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("memberPw");
			} else {
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * public void insertMember() { System.out.println("test"); Scanner sc = new
	 * Scanner(System.in);
	 * 
	 * System.out.print("회원ID: "); String id = sc.next(); System.out.print("pw: ");
	 * String pw = sc.next(); System.out.print("name 입력: "); String name =
	 * sc.next(); System.out.print("tel 입력: "); String tel = sc.next();
	 * System.out.print("birth 입력: "); String birth = sc.next();
	 * System.out.print("email 입력: "); String email = sc.next();
	 * System.out.print("gender 입력: "); int gender = sc.nextInt();
	 * System.out.print("nick 입력: "); String nick = sc.next();
	 * System.out.print("addrress 입력: "); String addrress = sc.next();
	 * 
	 * String runSP = "{ call member_insert(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
	 * 
	 * try { Connection conn = DBConnection.getConnection(); CallableStatement
	 * callableStatement = conn.prepareCall(runSP); callableStatement.setString(1,
	 * id); callableStatement.setString(2, pw); callableStatement.setString(3,
	 * name); callableStatement.setString(4, tel); callableStatement.setTimestamp(5,
	 * Timestamp.valueOf(LocalDateTime.now())); callableStatement.setString(6,
	 * email); callableStatement.setInt(7, gender); callableStatement.setString(8,
	 * nick); callableStatement.setString(9, addrress);
	 * 
	 * callableStatement.executeUpdate(); System.out.println("성공"); } catch
	 * (SQLException e) { System.err.format("SQL State: %s\n%s", e.getSQLState(),
	 * e.getMessage()); e.printStackTrace(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { sc.close(); }
	 * 
	 * }
	 */

	// 회원 정보 수정
	public void updateMember(String memberID, String memberPW, String memberTel, String memberEmail,
			String memberAddress) {
		String run = "{ call member_update(?,?,?,?,?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);
			callableStatement.setString(1, memberID);
			callableStatement.setString(2, memberPW);
			callableStatement.setString(3, memberTel);
			callableStatement.setString(4, memberEmail);
			callableStatement.setString(5, memberAddress);
			callableStatement.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 탈퇴
	public void deleteMember(String memberID) {
		String run = "{ call member_delete(?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);
			callableStatement.setString(1, memberID);
			callableStatement.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 마이페이지 접속시 비밀번호 확인 성공이면 1, 실패면 -1
	public int passwordCheck(String memberID, String memberPw) {
		int result = -1;
		String sql = "select * from member where memberid=? and memberPw = ?";

		try {
			Connection connn = DBConnection.getConnection();
			PreparedStatement pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			pstmt.setString(2, memberPw);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
