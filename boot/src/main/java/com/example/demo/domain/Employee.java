package com.example.demo.domain;

import java.sql.*;

import lombok.*;

@Data
public class Employee {
	private int EmployeeId;
	private String lastName;
	private String firstName;
	private Date birthDate;
	private String photo;
	private String notes;
}
