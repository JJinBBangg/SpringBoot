package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub20")
public class Controller20 {
	
	@Autowired
	private Mapper01 mapper01;
	
	@RequestMapping("link1")
	public void method1() {
		String name = mapper01.method1();
		System.out.println(name);
	}
	
	@RequestMapping("link2")
	public void method2() {
		List<Customer> list = mapper01.method2();
		System.out.println(list.get(0).toString());
	}
	
	@RequestMapping("link3")
	public void method3() {
		List<Employee> list = mapper01.method3();
		System.out.println(list.get(4).toString());
	}
	
	@RequestMapping("link4")
	public void method4() {
		List<Supplier> list = mapper01.method4();
		System.out.println(list.get(1).toString());
	}
	
	@RequestMapping("link5")
	public void method5() {
		Customer customer = mapper01.method5(3);
		System.out.println(customer.toString());
	}
	
	@RequestMapping("link6")
	public void method6(int id) {
		Employee employee = mapper01.method6(id);
		System.out.println(employee.toString());
	}
}