package com.example.demo.domain;

import lombok.*;

@Data
public class Product {
	private int productId;
	private String productName;
	private String supplierId;
	private String categoryId;
	private String unit;
	private double price;
}
