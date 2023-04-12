package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sub2/")
public class Controller02 {

	@RequestMapping("link1")
	public void method1() {
		System.out.println("일함");
	}

	@GetMapping("link2")
	public void method2() {
		System.out.println("일함");
	}

	@GetMapping("link3")
	public String method3() {
		System.out.println("일함");
		return "";
	}
}
