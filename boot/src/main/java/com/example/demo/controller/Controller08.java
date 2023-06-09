package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub8")
public class Controller08 {
	@RequestMapping("link1")
	public String method1(@ModelAttribute("val") Dto04 dto04) {
		dto04.setName("송태섭");
		dto04.setAge(50);
		return "/sub7/link10";
	}
	@RequestMapping("link2")
	public void method2(@ModelAttribute("product") Dto02 dto02) {
		dto02.setCompany("KIA");
		dto02.setModel("쏘렌토");
		dto02.setPrice(4500);
	}
	
//	model attribute의 이름을 생략하면 클래스 이름을 lowerCamelCase
//	예) CompanyMember - > companyMember
	@RequestMapping("link3")
	public void method3(@ModelAttribute Dto02 dto02, @ModelAttribute Dto03 dto03) {
		dto02.setCompany("KIA");
		dto02.setModel("쏘렌토");
		dto02.setPrice(4500);
		
		dto03.setAge(30);
		dto03.setName("강백호");
	}
}
