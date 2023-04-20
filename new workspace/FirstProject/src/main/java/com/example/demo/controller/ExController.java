package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExController {
	
	@GetMapping("/1")
	public String method1() {
		System.out.println("ff");
		return "/NewFile.html";
	}
	@GetMapping("/2")
	public String method2() {
		return "vueLifeCycle";
	}
	@GetMapping("/3")
	public String method3() {
		return "template";
	}
	@GetMapping("/4")
	public String method4() {
		return "component";
	}
	@GetMapping("/5")
	public String method5() {
		return "watch";
	}
	@GetMapping("/6")
	public String method6() {
		return "computed";
	}
	@GetMapping("/7")
	public String method7() {
		return "computedWatch";
	}
	@GetMapping("/8")
	public String method8() {
		return "computedSetGet";
	}
	@GetMapping("/9")
	public String method9() {
		return "AttributeBind";
	}
	@GetMapping("/10")
	public String method10() {
		return "CssClassBinding";
	}
	@GetMapping("/11")
	public String method11() {
		return "inlineStyleBinding";
	}
	@GetMapping("/12")
	public String method12() {
		return "FormBinding";
	}
	@GetMapping("/13")
	public String method13() {
		return "/vueExam/Event";
	}
	@GetMapping("/14")
	public String method14() {
		System.out.println("dd");
		return "/articles/Event.html";
	}
}
