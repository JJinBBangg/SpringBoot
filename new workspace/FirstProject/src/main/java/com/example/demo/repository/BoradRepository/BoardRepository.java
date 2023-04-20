package com.example.demo.repository.BoradRepository;

import java.util.List;

import com.example.demo.entity.Notice;

public interface BoardRepository {
	List<Notice> findAll();
	void findById();
	void deleteById(Long id);
	Notice save(Notice notice); 

}
