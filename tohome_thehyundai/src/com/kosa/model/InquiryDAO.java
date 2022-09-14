package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.kosa.dbUtil.DBConnection;
import com.kosa.dbUtil.DbUtil;
import com.kosa.entity.InquiryVO;

import oracle.jdbc.OracleTypes;

public class InquiryDAO {
   
   private InquiryDAO() {
   }

   private static InquiryDAO instance = new InquiryDAO();
   //DAO 싱글톤패턴??
   public static InquiryDAO getInstance() {
      return instance;
   }
   
   // 문의내역들 화면에 뿌려주기
   public ArrayList<InquiryVO> viewInquiry(int quiryId, String member_memberId) {
      ArrayList<InquiryVO> inquiryList = new ArrayList<InquiryVO>();
      
      String runSelect_Inquiry = "{ call select_inquiry(?, ?, ?) }";

      try {
         Connection conn = DBConnection.getConnection();
         CallableStatement callableStatement = conn.prepareCall(runSelect_Inquiry);
         callableStatement.setInt(1, quiryId);
         callableStatement.setString(2, member_memberId);
         callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
         
         try {
            callableStatement.execute();
            ResultSet resultSet = (ResultSet) callableStatement.getObject(3);
            
            while (resultSet.next()) {   
               InquiryVO inquiry = new InquiryVO();
               inquiry.setQuiryType(resultSet.getString(2));
               inquiry.setQuiryDate(resultSet.getDate(3));
               inquiry.setQuiryContent(resultSet.getString(4));
               inquiryList.add(inquiry);
            }

         } catch (SQLException e) {
            System.out.println("프로시저에서 에러 발생!");
            // System.err.format("SQL State: %s", e.getSQLState());
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         
      }
      return inquiryList;
   }
   
//    //dao test 하기위한 main메소드
//   	public static void main(String[] args) {
////   		InquiryVO inquiryVO = new InquiryVO();
////   		inquiryVO.setQuiryType("기타");
////   		inquiryVO.setQuiryDate(Date.valueOf(LocalDate.now()));
////   		inquiryVO.setQuiryContent("문의 테스트");
////   		inquiryVO.setQuiryImg("https://www.naver.com");
////   		inquiryVO.setMember_memberId("asd");
////   		System.out.println(insertInquiry(inquiryVO));
//   			System.out.println(deleteInquiry(16));
//   	}
   
   	 //문의내역 db에 저장
     public int insertInquiry(InquiryVO inquiryVO) {
          int result = 1;
               
         String runSP = "{ call insert_inquiry(?, ?, ?, ?, ?) }";

         try {
            Connection conn = DBConnection.getConnection();
            CallableStatement callableStatement = conn.prepareCall(runSP);
            callableStatement.setString(1, inquiryVO.getQuiryType());
            callableStatement.setDate(2, inquiryVO.getQuiryDate());
            callableStatement.setString(3, inquiryVO.getQuiryContent());
            callableStatement.setString(4, inquiryVO.getQuiryImg());
            callableStatement.setString(5, inquiryVO.getMember_memberId());
            callableStatement.executeUpdate();   
            System.out.println("성공");         
         } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
         }
         return result;
     }
     
     //문의내역 db에서 삭제
     public int deleteInquiry(int quiryId) {
        int result = 0;
        String runSP = "{ call delete_inquiry(?) }";
        
        try {
           Connection conn = DBConnection.getConnection();
           CallableStatement callableStatement = conn.prepareCall(runSP);
           callableStatement.setInt(1, quiryId);
           callableStatement.executeUpdate();
           System.out.println("성공");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
         }
         return result;
     }
     
     
}