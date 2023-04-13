package com.project.repository.NoriceRepository;

import java.util.*;

import com.project.entity.*;

public interface NoticeRepository {
	List<Notice> findAll();
	void findById();
	void deleteById(Long id);
	Notice save(Notice notice); 
}
