/* 
 * 작성자 : 김다빈, 신기원
 */
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

	//클래스 변수를 통해 인스턴스 생성
	private static MemberDAO instance = new MemberDAO();

	public MemberDAO() {

	}
	
	//다른 클래스에서 new를 직접 사용하지 않고 객체를 생성
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

	//회원 정보 조회
	public MemberVO selectMember(String memberID) {
		MemberVO memberVO = new MemberVO();
		String run = "{call MEMBER_SELECT(?,?)}";
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			//프로시저에 Id와 select문의 결과를 담을 cursor를 전달해줌
			callableStatement.setString(1, memberID);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				//데이터가 저장된 cursor를 ResultSet에 담음
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {

					//데이터로 memberVO 조립
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

	// id 중복체크
	public String idCheck(String memberId) {
		System.out.println("idCheck 여기왔다");

		String run = "{call MEMBER_CHECKID(?,?)}";
		String result ="";
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);
			
			callableStatement.setString(1, memberId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				
				
				
				while (resultSet.next()) {
					result = resultSet.getString(1);
					System.out.println("MemberDAO result 값 : "+result);
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

		return result;
	}
	
	// 닉네임 중복체크
	public String nickCheck(String memberNickname) {
		System.out.println("nickCheck 여기왔다");

		String run = "{call MEMBER_CHECKNICKNAME(?,?)}";
		String result = "";
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberNickname);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {
					result = resultSet.getString(1);
					System.out.println("MemberDAO result 값 : " + result);
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

		return result;
	}
	
	// 전화번호 중복체크
	public String telCheck(String memberTel) {
		System.out.println("telCheck 여기왔다");

		String run = "{call MEMBER_CHECKTEL(?,?)}";
		String result = "";
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberTel);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {
					result = resultSet.getString(1);
					System.out.println("MemberDAO result 값 : " + result);
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

		return result;
	}
	
	// 이메일 중복체크
		public String emailCheck(String memberEmail) {
			System.out.println("emailCheck 여기왔다");

			String run = "{call MEMBER_CHECKEMAIL(?,?)}";
			String result = "";
			try {
				Connection conn = DBConnection.getConnection();
				CallableStatement callableStatement = conn.prepareCall(run);

				callableStatement.setString(1, memberEmail);
				callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
				System.out.println();

				try {
					callableStatement.execute();
					ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

					while (resultSet.next()) {
						result = resultSet.getString(1);
						System.out.println("MemberDAO result 값 : " + result);
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

			return result;
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

	// 회원 정보 수정
	public void updateMember(String memberID, String memberPW, String memberTel, String memberEmail,
			String memberAddress) {
		String run = "{ call member_update(?,?,?,?,?) }";
		
		// 프로시저에서 update문을 사용하기 때문에 따로 반환되는 데이터가 없다.
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
		
		//파라미터로 받아온 id와 비밀번호가 일치하는지 확인하는 sql
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
