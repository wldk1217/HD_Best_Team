/*
 * 코드 작성자: 김민석
 */
package com.kosa.entity;

import lombok.Data;
import java.sql.*;

// 문의테이블의 값을 받아오기 위한 InquiryVO
@Data
public class InquiryVO {
	private int quiryId;
	private String quiryType;
	private Date quiryDate;
	private String quiryContent;
	private String quiryImg;
	private String member_memberId;
}
