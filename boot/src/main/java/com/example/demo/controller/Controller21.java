package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub21")
public class Controller21 {
	
	@Autowired
	private Mapper02 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		List<Customer> customerList = mapper.method1();
		customerList.stream().forEach(System.out::println);
	}
	@RequestMapping("link2")
	public void method2() {
		List<Product> productList = mapper.method2();
		productList.stream().forEach(p -> {
		});
	}
	@RequestMapping("link3/{id}")
	public void method3(@PathVariable int id) {
		List<Product> productList = mapper.method3(id);
		productList.stream().forEach(p -> {
		});
	}
}
