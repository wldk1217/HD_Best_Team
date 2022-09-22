/* 
 * 작성자 : 신기원
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

//비밀번호 재인증
public class PasswordCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		
		//세션 객체
		HttpSession session = request.getSession();
		
		//로그인 한 회원Id의 세션값
		String id = (String) session.getAttribute("memberId");	
	    
		//MemberDAO 생성 getInstance = new MemberDAO()를 생성
	    MemberDAO memberDAO=MemberDAO.getInstance();
	    // request 객체에서 받아온 비밀번호를 회원Id 값을 통해 DB의 비밀번호에서 전달 받는 값이 일치하는지 확인 
	    String pwd = request.getParameter("PWD");
	    
	    // 반환 값
	    int checked = memberDAO.passwordCheck(id, pwd);
	    
	    if(checked == 1){
	    	//수정 페이지로 이동
	    	url="tohomeServlet?command=mypage_update_form";
	    	response.sendRedirect(url);
	      
	    }else {
	    	//다시 비밀번호를 입력하는 마이페이지로
	    	url="tohomeServlet?command=mypage";
	    	response.sendRedirect(url);
	    }
	    
	}

}
