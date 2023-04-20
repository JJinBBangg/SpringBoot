package com.example.demo.repository.BoradRepository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Notice;

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
	public List<Notice> findAll() {
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
