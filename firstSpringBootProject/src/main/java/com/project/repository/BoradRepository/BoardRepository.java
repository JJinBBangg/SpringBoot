package com.project.repository.BoradRepository;

import java.util.*;

import com.project.entity.*;

public interface BoardRepository {
	List<Board> findAll();
	void findById();
	void deleteById(Long id);
	Notice save(Notice notice); 

}
