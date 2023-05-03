package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.*;

@RequestMapping("sun26")
public class Controller26 {
	
	@Autowired
	private Mapper05 mapper;
	
	@GetMapping("link1")
	public void method1() {
	}
	
	@GetMapping("link2")
	public void method2() {
		
	}
}
