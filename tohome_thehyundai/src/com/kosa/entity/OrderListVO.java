/*
 * 코드 작성자 : 신기원
 */
package com.kosa.entity;

import lombok.Data;

@Data
public class OrderListVO {

	private ProductVO product;
	private int orderID;
	private int orderQuantity;
}
