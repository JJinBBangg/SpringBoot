package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub7")
public class Controller07 {

	@RequestMapping("link1")
	public void method1() {

	}

	@RequestMapping("link2")
	public String method2(Model model) {
		model.addAttribute("list", List.of("서태웅", "강백호"));
		return ("/sub7/link1");
	}

	@RequestMapping("link3")
	public void method3(Model model) {
		model.addAttribute("address", "서울");
	}

	@RequestMapping("link4")
	public void method4(Model model) {
		model.addAttribute("list", List.of("서태웅", "강백호"));
	}
	@RequestMapping("link5")
	public String method5(Model model) {
		model.addAttribute("map", Map.of("name", "강백호"));
		return ("/sub7/link4");
	}
	@RequestMapping("link6")
	public String method6(Model model) {
		model.addAttribute("map", Map.of("name", "이한나", "job", "매니저"));
		return ("/sub7/link4");
	}
	@RequestMapping("link7")
	public void method7(Model model) {
		model.addAttribute("age", 40);
		model.addAttribute("country", "한국");
		model.addAttribute("movieList", new String[] {});
	}
	@RequestMapping("link8")
	public void method8(Model model) {
		Dto01 o1 = new Dto01();
		o1.setName("박지성");
		o1.setAge(40);
		model.addAttribute("player", o1);
	}
	@RequestMapping("link9")
	public void method9(Model model) {
		Dto02 o1 = new Dto02();
		o1.setCompany("현대");
		o1.setModel("소나타");
		o1.setPrice(3000);
		model.addAttribute("carList", o1);
	}
	@RequestMapping("link10")
	public void method10(Model model) {
		Dto04 o1 = new Dto04();
		o1.setName("송태섭");
		o1.setAge(30);
		model.addAttribute("player", o1);
	}
}
