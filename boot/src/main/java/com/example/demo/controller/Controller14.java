package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@RequestMapping("sub14")
@Controller
public class Controller14 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	@RequestMapping("link1")
	public String method1(Model model, String search) {
		String sql = """
				SELECT * FROM Customers WHERE CustomerName OR ContactName LIKE ?
				""";
		List<Customer> list = new ArrayList<>(); 
		try (Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, "%"+search+"%");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer(
//						rs.getInt("CustomerID"),
//						rs.getString("CustomerName"),
//						rs.getString("ContactName"),
//						rs.getString("Address"),
//						rs.getString("City"),
//						rs.getString("PostalCode"),
//						rs.getString("Country")
						);
				list.add(customer);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("customerList", list);
		return "/sub13/link4";
	}

}
