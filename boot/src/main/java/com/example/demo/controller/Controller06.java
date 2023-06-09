package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("sub6")
public class Controller06 {
	
	@RequestMapping("link1")
	public String method1() {
		System.out.println("link1 메소드 일함");
		return "/sub6/link2";
	}
	@RequestMapping("link2")
	public String method2() {
		System.out.println("link2 메소드 일함");
		return "redirect:/sub6/link3";
	}
	@RequestMapping("link3")
	public String method3() {
		System.out.println("link3 메소드 일함");
		return "";
	}
	@RequestMapping("link4")
	public String method4(Model model) {
		model.addAttribute("");
		return "/WEB-INF/views/abc.jsp";
	}
	@RequestMapping("link5")
	public String method5(Model model) {
		model.addAttribute("");
		return "/WEB-INF/views/abc.jsp";
	}
	@RequestMapping("link6")
	public String method6(Model model) {
		model.addAttribute("");
		return "abc";
	}
	@RequestMapping("link7")
	public String method7(Model model) {
		model.addAttribute("");
		return "def";
	}
	@RequestMapping("link8")
	public String method8() {
		System.out.println("8번 메소드 일함");
		return "/WEB-INF/views/sub6/link8.jsp";
	}
	@RequestMapping("link9")
	public void method9() {
		//requestmapping주소와 동일한 주소를 찾아감 
		// resource
		System.out.println("9번 메소드 일함");
	}
}
