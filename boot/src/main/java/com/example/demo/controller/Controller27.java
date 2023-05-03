package com.example.demo.controller;

import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.cache.CacheProperties.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub28")
public class Controller27 {
	
	@Autowired
	private Mapper07 mapper;
	
	@GetMapping("link1")
	public void method1() {
		mapper.sql1(List.of("강백호","송태섭","채치수"));
	}
	@GetMapping("link2")
	public void method2() {
		System.out.println(mapper.sql2(List.of("UK","USA","Japan")));
		mapper.sql2(List.of("UK","USA","Japan")).stream().forEach(System.out::println);
		System.out.println(mapper.sql2(List.of("Brazil","Germany")));
		mapper.sql2(List.of("Brazil","Germany")).stream().forEach(System.out::println);
	}
	@GetMapping("link3")
	public void method3() {
		
	}
	@GetMapping("link4")
	public void method3(@RequestParam(value="country", required = false) List<String> country) {
		mapper.sql2(country).stream().map(String::valueOf).collect(Collectors.toList()).stream().forEach(System.out::println);/*forEach(System.out::println)*/;
		String[] a = {"123","sdf","ss","ff"};
		Arrays.asList(a).stream().forEach(System.out::println);
		
	}

}
