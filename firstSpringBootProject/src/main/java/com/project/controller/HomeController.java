package com.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.project.entity.*;
import com.project.repository.NoriceRepository.*;

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
