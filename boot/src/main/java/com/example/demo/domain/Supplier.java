package com.example.demo.domain;

import java.util.*;

import lombok.*;

@Data
public class Supplier {
	private int supplierId;
	private String supplierName;
	private String contactName;
	private String address;
	private String city;
	private String country;
	private String postalCode;
	private String phone;
	private List<Products> products;
	private List<Category> categories;
}
