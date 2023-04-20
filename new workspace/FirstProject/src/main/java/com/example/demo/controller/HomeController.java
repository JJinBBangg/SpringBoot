package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Notice;
import com.example.demo.repository.NoticeRepository.JDBCNoticeRepository;



@Controller
public class HomeController {
	
    
    private JDBCNoticeRepository NoticeRepository;
    
    @Autowired 
	public HomeController(JDBCNoticeRepository noticeRepository) {
		NoticeRepository = noticeRepository;
	}



	@GetMapping("home")
	public String homePage(Model model) {
		List<Notice> list =NoticeRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "/home/home";
	}
	@GetMapping("login")
	public String login() {
		
		return "/home/login";
	}
	@GetMapping("board")
	public String board() {
		
		return "/board/board";
	}
}
