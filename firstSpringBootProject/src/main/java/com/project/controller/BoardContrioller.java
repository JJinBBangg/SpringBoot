package com.project.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.project.repository.BoradRepository.*;

@Controller
public class BoardContrioller {
	
	private final JDBCBoardRepository BoardRepository;
	
	@Autowired
	public BoardContrioller(JDBCBoardRepository boardRepository) {
		BoardRepository = boardRepository;
	}
	
	
	
	
	
}
