package com.kosa.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import lombok.Data;

@Data
public class OrdersVO {

	private int orderId;
	private Date orderDate;
	private String paymenttype;
	private int totalPrice;
	private String orderState;
	private int orderCount;
}
