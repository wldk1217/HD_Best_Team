/*
 * 코드 작성자 : 민지아
 */
package com.kosa.entity;

import lombok.Data;

@Data
public class BasketVO {
	private String memberId;
	private int basketId;
	private String productImg;
	private int productPrice;
	private String productName;
	private int basketQuantity;
	private int productId;
}
