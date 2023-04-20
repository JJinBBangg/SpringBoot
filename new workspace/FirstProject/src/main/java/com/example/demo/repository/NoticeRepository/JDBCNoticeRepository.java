package com.example.demo.repository.NoticeRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Notice;


@Repository
public class JDBCNoticeRepository implements NoticeRepository {

	private final DataSource dataSource;

	@Autowired
	public JDBCNoticeRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Notice> findAll() {
		List<Notice> list = new ArrayList<>();
		String sql = "SELECT * FROM NOTICE";
		try {
			Connection con = dataSource.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Long id = rs.getLong("id");
				String title = rs.getString("title");
				String writerId = rs.getString("writer_id");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				int pub = rs.getInt("pub");
				Notice notice = new Notice(id, title, writerId, content, regdate, hit, files, pub);
				list.add(notice);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Notice save(Notice notice) {
		// TODO Auto-generated method stub
		return null;
	}
}