package com.example.demo.repository.NoticeRepository;

import java.util.List;

import com.example.demo.entity.Notice;

public interface NoticeRepository {
	List<Notice> findAll();
	void findById();
	void deleteById(Long id);
	Notice save(Notice notice); 
}
