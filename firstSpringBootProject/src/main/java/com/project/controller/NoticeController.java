package com.project.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.project.repository.NoriceRepository.*;

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
