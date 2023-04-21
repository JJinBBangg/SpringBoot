package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub24")
public class Controller24 {

	@Autowired
	private Mapper05 mapper;

	@RequestMapping("link1")
	public void method1(Dto12 dto) {
		int cnt = mapper.sql1(dto);
		System.out.println(cnt + "개 행 수정됨");
	}

	@RequestMapping("link2")
	public String method2(Customer customer) {
		return "/sub24/link4";
	}

	@RequestMapping("link3")
	public String method3(Customer customer) {
		mapper.sql2(customer);
		return "/sub24/link4";
	}
	
	@RequestMapping("link4")
	public void method4(Customer customer) {
		
	}

}
