package com.project.repository.BoradRepository;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.project.entity.*;

@Repository
public class JDBCBoardRepository implements BoardRepository {

	private final DataSource dataSource;

	@Autowired
	public JDBCBoardRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Board> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub

	}

	@Override
	public Notice save(Notice notice) {
		// TODO Auto-generated method stub
		return null;
	}

}
