package com.kosa.entity;

import java.util.*;

import lombok.Data;

@Data
public class ProductVO {
	private int productId;
	private String productName;
	private int productPrice;
	private String productOrigin;
	private int productStock;
	private Date productDate;
	private String productDetail;
	private int productSale;
	private String productImg;
	private int Category_categoryId;
}
