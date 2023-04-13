package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub9")
public class Controller09 {
	
	@RequestMapping("link1")
	public String method01(@ModelAttribute Dto04 dto04, Model model, @RequestParam (defaultValue = "")String name,@RequestParam (defaultValue ="0") int age) {
		dto04.setName(name);
		dto04.setAge(age);
		
		return "/sub9/link1";
	}
	@RequestMapping("link2")
	public String method02(@ModelAttribute Dto04 dto04, Model model, @RequestParam (defaultValue = "")String name,@RequestParam (defaultValue ="0") int age) {
		
		return "/sub9/link2";
	}
	
	// String, primitive는 @RequestParam 으로 인식
	// String int 값 Dto04에 set 됨(set 함수 구현되어있어함)
	// 위 parameter 생략 시 @ModelAttribute Dto04 내부에 setter로 구현되어있는 이름이 같을 시 자동으로 주입
	// 위 타입 이외의 아큐먼트 작성 시 @ModelAttribute로 인식함
	// Dto04 @ModelAttribute로 간주 함  
	@RequestMapping("link3")
	public void method03(Dto04 dto04) {
		// void 일 경우 위 요청경로와 동일한 view 파일 찾아감 
		
		// application.properties view resolver 세팅 prefix + 위 요청 주소 + suffix  
	}
	@RequestMapping("link4") // Dto04 set으로 설정되지 않은 parameter는 param을 Map타입으로 model에 담아서 전달함
	public void method04(Dto04 dto04) {
	}
}
