package com.example.demo.domain;

import java.time.*;

import lombok.*;

@Data
public class Dto05 {
	private String name;
	private Integer age;
	private Double price;
	private LocalDate birth;
	private LocalDateTime inserted;
}
