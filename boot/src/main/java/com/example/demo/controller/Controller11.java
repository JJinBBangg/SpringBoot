package com.example.demo.controller;

import java.sql.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class Controller11 {
	@RequestMapping("link1")
	public void method1() {
		Connection con;
		try {
			con = DriverManager.getConnection(url, name, passward);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(null);
			if (rs.next()) {
				rs.getString("CustomerName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
