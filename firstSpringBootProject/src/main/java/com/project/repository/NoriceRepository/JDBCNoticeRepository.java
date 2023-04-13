package com.project.repository.NoriceRepository;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.project.entity.*;
import com.project.repository.*;

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