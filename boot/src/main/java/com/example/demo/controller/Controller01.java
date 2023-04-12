package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controller01 {

	@GetMapping("/sub1/link1")
	public void method1() {
		System.out.println("일함");
	}

	@GetMapping("/sub1/link2")
	public void method2() {
		System.out.println("일함");
	}

	@GetMapping("/sub1/link3")
	public String method3() {
		System.out.println("일함");
		return "";
	}
}
