package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub31")
public class Controller31 {

	@Autowired
	private Mapper11 mapper;
	
	@GetMapping("link1")
	public void method1(int id) {
		Category category = mapper.sql(id);
		System.out.println(category);
		category.getProductNames().stream().forEach(System.out::println);
	}
	@GetMapping("link2")
	public void method2(int id) {
		// 1번 카테고리 정보
		Category category = mapper.sql2(id);

		System.out.println(category);
		category.getProduct().forEach(System.out::println);
	}
	@GetMapping("link3")
	public void method3(int id) {
		// 1번 카테고리 정보
		Supplier supplier = mapper.sql3(id);
		
		System.out.println(supplier);
		supplier.getProducts().forEach(System.out::println);
		supplier.getCategories().forEach(System.out::println);
	}
}
