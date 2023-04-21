package com.example.demo.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private int customerId;
	private String customerName;
	private String address;
	private String contactName;
	private String city;
	private String postalCode;
	private String country;
}
