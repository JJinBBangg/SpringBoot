package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.NoticeRepository.JDBCNoticeRepository;

@Controller
public class NoticeController {

	
	private final JDBCNoticeRepository noticeRepository;

	public NoticeController(JDBCNoticeRepository repository) {
		this.noticeRepository = repository;
	}
	
	@GetMapping("notice")
	public String notice() {
		
		return "/notice/notice";
	}
	@GetMapping("/notice/detail")
	public String noticeDetail() {
		
		return "/notice/noticeDetail";
	}
}
