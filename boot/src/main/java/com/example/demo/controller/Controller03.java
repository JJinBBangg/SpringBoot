package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub3")
public class Controller03 {

	@RequestMapping("link1")
	public void method1() {
		System.out.println("일함1");
	}

	@GetMapping("link2")
	public String method2() {
		System.out.println("일함2");
		return "";
	}
}
