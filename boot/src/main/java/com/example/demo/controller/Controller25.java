package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub25")
public class Controller25 {

	@RequestMapping(value = "link1", method = RequestMethod.GET)
	public void mehtod1() {

	}

	@GetMapping("link2")
	public void mehotd2() {

	}

	@PostMapping("link3")
	public void method3() {

	}

	@GetMapping("link4/{id}")
	public void method4(@PathVariable int id) {

	}

	@GetMapping("link5/{id}/{age}")
	public void method5(@PathVariable int id, @PathVariable int age) {

	}

	@GetMapping("link6/id/{id}/name/{name}")
	public void method6(@PathVariable int id, @PathVariable int name) {

	}
	@GetMapping("link7")
	public String method7() {
		
		return "hello";
	}
	
	@GetMapping("link8")
	public String method8() {
		
		return "redirect:/sub25/link7";
	}
	
	@GetMapping("link9")
	public String method9(HttpSession s) {
		s.setAttribute("attr1", "hi");
		return "redirect:/sub25/link10";
	}
	
	@GetMapping("link10")
	public void method10(){
		
	}
	
	@GetMapping("link11")
	public String method11(RedirectAttributes rttr){
		rttr.addFlashAttribute("attr1", "hello");
		return "redirect:link10";
	}
	
	@GetMapping("link12")
	public String method12(RedirectAttributes rttr){
		rttr.addFlashAttribute("list", List.of("hi", "hello"));
		return "redirect:link13";
	}
	@GetMapping("link13")
	public void method13() {
		
	}
	
	
	
	
	
	
	
	
	
	
}
