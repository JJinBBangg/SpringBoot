package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub22")
public class Controller22 {

	@Autowired
	private Mapper03 mapper;

	@RequestMapping("link1")
	public void method1(String name, String address) {
		int customer = mapper.method1(name, address);
		System.out.println(customer);
	}

	@RequestMapping("link2")
	public void method2(Customer customer, int customerId) {

		int result = mapper.method2(customer, customerId);
		System.out.println(result + "행 추가됨");
	}

	@RequestMapping("link3")
	public void method3(Customer cutomer, int customerId) {

	}

	@RequestMapping("link4")
	public void method4() {
		Dto09 dto = new Dto09();
		dto.setProp1(300);
		dto.setProp2("hello mybatis");
		dto.setProp3(33.33);

		int cnt = mapper.sql3(dto);
		System.out.println(cnt);
	}

	@RequestMapping("link5")
	public void method5() {
		Dto10 dto = new Dto10();
		dto.setAge(333);
		dto.setName("spring");
		dto.setScore(99.99);

		int cnt = mapper.sql4(dto);
		System.out.println(cnt + "행 입력됨");
	}

	// /sub22/link6?age=77&name=park&score=88.88
	@RequestMapping("link6")
	public void method6(@ModelAttribute Dto10 dto) {
		int cnt = mapper.sql4(dto);
		System.out.println(cnt + "개 행 입력됨");
	}

	// MyTable36에 데이터 추가될 수 있게
	// 아래 코드 수정하기
	// /sub22/link7?prop1=33&prop2=world&prop3=33.44
	@RequestMapping("link7")
	public void method7(Dto09 dto) {
		int cnt = mapper.sql3(dto);
		System.out.println(cnt + "개 행 입력됨");
	}

	@RequestMapping("link8")
	public void method8() {
		Dto09 dto1 = new Dto09();
		Dto10 dto2 = new Dto10();
		dto1.setProp1(345);
		dto2.setName("서태웅");
		dto1.setProp3(99.88);

		int cnt = mapper.sql5(dto1, dto2);
		System.out.println(cnt + "개 행 추가됨");
	}

	@RequestMapping("link9")
	public void method9() {
		Dto09 o1 = new Dto09();
		Dto10 o2 = new Dto10();

		o1.setProp1(12345);
		o1.setProp2("점심시간");
		o1.setProp3(88.77);

		o2.setAge(54321);
		o2.setName("돈까스");
		o2.setScore(77.88);

		int cnt = mapper.sql6(o1, o2);
		System.out.println(cnt + "개 행 입력완료");
	}

	// /sub22/link10?prop1=7&prop2=lunch&prop3=3.14&age=8&name=song&score=3.14
	@RequestMapping("link10")
	public void method10(Dto09 p1, Dto10 p2) {
		int cnt = mapper.sql6(p1, p2);
		System.out.println(cnt + "행 입력!");
	}

	// /sub22/link11?prop2=mybatis&prop3=321
	@RequestMapping("link11")
	@ResponseBody
	public String mehtod11(Dto11 dto) {
		System.out.println("prop1:" + dto.getProp1());
		int cnt = mapper.sql7(dto);
		System.out.println(cnt + "행 입력 완료!!");
		System.out.println("prop1:" + dto.getProp1());

		return dto.getProp1() + "번째 데이터 입력완료";
	}
	
	@RequestMapping("link12")
	@ResponseBody
	public String mehtod12(Dto12 dto) {
		int cnt = mapper.sql8(dto);
		System.out.println(cnt + "행 입력 완료!!");

		return dto.getId() + "번째 데이터 입력완료";
	}
}
