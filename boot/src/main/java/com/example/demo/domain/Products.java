package com.example.demo.domain;

import lombok.*;

@Data
public class Products {
	private int productId;
	private String productName;
	private String supplierId;
	private String categoryId;
	private String unit;
	private double price;
}
