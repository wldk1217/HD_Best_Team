package com.kosa.entity;

import lombok.Data;

@Data
public class OrderListVO {

	private ProductVO product;
	private int orderID;
	private int orderQuantity;
}
