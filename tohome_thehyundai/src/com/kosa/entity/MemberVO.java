/*
 * 코드 작성자 : 김다빈
 */
package com.kosa.entity;

import lombok.Data;

// 회원들의 값을 받아오기 위한 MemberVO
@Data
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberTel;
	private String memberBirth;
	private String memberEmail;
	private int memberGender;
	private String memberNickname;
	private String joinDate;
	private String memberAdderss;
	
}
