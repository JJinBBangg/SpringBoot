package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub23")
public class Controller23 {
	
	@Autowired
	 private mapper04 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		int cnt = mapper.sql1();
		System.out.println( cnt+"개 행 삭제됨");
	}
	
	@RequestMapping("link2/{id}")
	@ResponseBody
	public String method2(@PathVariable Integer id) {
		int cnt = mapper.sql2(id);
		return cnt + "개 행 삭제됨";
	}
	
	@RequestMapping("link3/{id}")
	public void method3(@PathVariable int id) {
		int cnt = mapper.sql3(id);
		System.out.println(cnt + "개 행 삭제됨");
	}
}
