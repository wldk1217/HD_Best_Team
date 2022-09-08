package com.kosa.entity;

import lombok.Data;

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
