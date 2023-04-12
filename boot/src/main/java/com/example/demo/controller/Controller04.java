package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub4")
public class Controller04 {
	
	@RequestMapping("link1")
	public String method1(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println(name);
		System.out.println(age);
		
		return "";
	}
	@RequestMapping("link2")
	public String method2(HttpServletRequest request) {
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		System.out.println(address);
		System.out.println(email);
		
		return "";
	}
	@RequestMapping("link3")
	public String method3(@RequestParam(name = "address", defaultValue = ""/* , required = false */) String address) {
		System.out.println(address);
		return "";
	}
	@RequestMapping("link4")
	public String method4(@RequestParam(name="age", defaultValue ="0") String age) {
		System.out.println(age);
		return "";
	}
	
	@RequestMapping("link5")
	public String method5(String eamil) {
		System.out.println(eamil);
		return "";
	}
}
