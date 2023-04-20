package com.example.demo.domain;

import java.time.*;

import lombok.*;

@Data
public class Dto06 {
	private String title;
	private Integer price;
	private Double weight;
	private LocalDateTime updated;
	private LocalDate published;
}
