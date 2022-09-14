package com.kosa.entity;

import lombok.Data;
import java.sql.*;
@Data
public class InquiryVO {
	private int quiryId;
	private String quiryType;
	private Date quiryDate;
	private String quiryContent;
	private String quiryImg;
	private String member_memberId;
}
