package com.example.demo.controller;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.http.ResponseCookie.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

import lombok.*;

@Controller
@RequestMapping("sub34")
public class Controller34 {
	
	@Autowired
	private Mapper11 mapper;

	@GetMapping("ajax1")
	public void method() {
		
	}
	
	@GetMapping("link1")
	@ResponseBody
	public String method1() {
		System.out.println("Hello Ajax");
//		Customer customer =("마포");
		return "첫번째 응답 데이터"; 
	}
	
	@GetMapping("link2")
	@ResponseBody
	public Customer method2() {
		System.out.println("Hello Ajax");
		Customer customer = new Customer();
		customer.setCity("서울");
		customer.setAddress("마포");
		return customer; 
	}
	@GetMapping("link3")
	@ResponseBody
	public Supplier method3(@RequestParam("id") int id) {
		System.out.println("Hello Ajax");
		return mapper.sql3(id);
	}
	@PostMapping("link4")
	@ResponseBody
	public AuthEamil method4(@RequestBody List<AuthEamil> dto) {
//		System.out.println(dto.get(0).getEmail());
//		System.out.println(dto.get(0).getPerson().getAge());
//		System.out.println(dto.get(0).getPerson().getName());
		System.out.println(dto.get(0).toString());
		System.out.println(dto.get(1).toString());
//		System.out.println(dto.get(1).getEmail()); 
//		System.out.println(dto.get(1).getPerson().getAge());
//		System.out.println(dto.get(1).getPerson().getName());
		String email1 = "kk@nate.com";
	     
	    if (dto.get(0).getEmail().equals(email1)) {
	        dto.get(0).setMessage("중복된 이메일 입니다.");
	    } else {
	        dto.get(0).setMessage("사용 가능한 이메일 입니다.");
	    }

	    return dto.get(0);
	}

	@Data
	static class AuthEamil {
	    private String email;
	    private String message;
	    private boolean married;
	    Person person;
	}
	@Data
	static class Person {
		private String name;
		private int age;
	}
	
	@GetMapping("link5")
	@ResponseBody
	public ResponseEntity<Object> method5(){
		ResponseCookie cookie = ResponseCookie.from("SESSION", "accessToken")
				.domain("localhost")
				.maxAge(3000)
				.sameSite("Strict")
				.build();
		ResponseEntity.status(400).header(HttpHeaders.SET_COOKIE, cookie.toString() ).build();
		ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString() ).build();
		ResponseEntity.status(500).header(HttpHeaders.SET_COOKIE, cookie.toString() ).build();
		
		ResponseEntity
		.status(HttpStatus.CONFLICT)
		.header(HttpHeaders.SET_COOKIE, cookie.toString() )
		.header("123","123")
		.body(null);
		
		ResponseEntity
	    .status(200)
	    .header(HttpHeaders.SET_COOKIE, cookie.toString())
	    .header("123", "123")
	    .body(ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(409), "중복된 아이디입니다."));
		
		ResponseEntity.ok()
		.header("","")
		.body("바디 값");
		
		ResponseEntity.ok() // status
		.header(HttpHeaders.SET_COOKIE, cookie.toString()) //header
		.header("", "")
		.body(null);
		

		
				DateTime time = new DateTime();
				time.setHour(LocalDateTime.now().getHour());
				time.setMinute(LocalDateTime.now().getMinute());
		return 	ResponseEntity
				.of(ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), "실패!!!!!!"))
				.build();
//		return 		ResponseEntity
//			    .status(200)
//			    .header(HttpHeaders.SET_COOKIE, cookie.toString())
//			    .header("123", "123")
//			    .body(ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(409), "중복된 아이디입니다."));
	}
	@Data
	static class DateTime{
		private int hour;
		private int minute;
	}
	
}
