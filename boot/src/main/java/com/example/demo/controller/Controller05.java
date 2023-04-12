package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub5")
public class Controller05 {

	@RequestMapping("link1")
	public String method1(@RequestParam(defaultValue = "")String name, int age, double score) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("score : " + score);
		return "";
	}
	@RequestMapping("link2")
	public String method2(@RequestParam(defaultValue = "korea")String address, 
							@RequestParam(defaultValue = "10")double height,
							@RequestParam(defaultValue = "10")double width) {
		System.out.println("address : " + address);
		System.out.println("height : " + height);
		System.out.println("width : " + width);
		return "";
	}
}
