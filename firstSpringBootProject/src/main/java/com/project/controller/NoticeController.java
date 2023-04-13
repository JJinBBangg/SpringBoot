package com.project.controller;

import org.springframework.stereotype.*;

import com.project.repository.NoriceRepository.*;

@Controller
public class NoticeController {

	
	private final JDBCNoticeRepository noticeRepository;

	public NoticeController(JDBCNoticeRepository repository) {
		this.noticeRepository = repository;
	}
	
}
