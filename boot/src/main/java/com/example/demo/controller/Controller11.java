package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub11")
public class Controller11 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.name}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) {
		// 2. business logic
		// SELECT CustomerName FROM Customers WHERE CustomerID = 1;
		
		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1";
		try (
			// db 연결
			Connection connection = DriverManager.getConnection(url, name, password);
			// Statement 객체 생성
			Statement statement = connection.createStatement();
			// 쿼리실행
			// 쿼리실행 결과 얻고
			ResultSet resultSet = statement.executeQuery(sql);
		) {
			// 쿼리실행 결과 가공
			String name = "";
			if (resultSet.next()) {
				name = resultSet.getString("CustomerName");
			}
			
			// 3. add attribute
			model.addAttribute("customerName", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 4. forward 
	}
	
	@RequestMapping("link2")
	public void method2() {
		String sql = "SELECT LastName FROM Employees WHERE EmployeeID=3 ";
		String lastName = "";
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			if(rs.next()) {
				lastName = rs.getString("lastName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(lastName);
	}
	@RequestMapping("link3")
	public void method3(Model model) {
		String sql = """
				SELECT * FROM 
				Products  
				WHERE ProductID=5
				""";
		int productId= 0;
		String productName = "";
		String unit = "";
		double price = 0;
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			if(rs.next()) {
				productId = rs.getInt("ProductID");
				productName = rs.getString("ProductName");
				unit = rs.getString("Unit");
				price = rs.getDouble("Price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("productId", productId);
		model.addAttribute("productName", productName);
		model.addAttribute("unit", unit);
		model.addAttribute("price", price);
	}
	@RequestMapping("link4")
	public void method4(Model model) {
		// #업무
		// 고객 이름들 조회
		
		String sql = """
				SELECT CustomerName
				FROM Customers
				""";
		
		List<String> list = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			try (con; stmt; rs;) {
				// list에 고객 이름들을 담고
				while (rs.next()) {
					list.add(rs.getString("CustomerName"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. add attribute
		model.addAttribute("customerNames", list);
		
		// 4. forward
	}
	@RequestMapping("link5")
	public void method5(Model model) {
		// #업무
		// 고객 이름들 조회
		
		String sql = """
				SELECT FirstName
				FROM Employees
				""";
		
		List<String> list = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			try (con; stmt; rs;) {
				// list에 고객 이름들을 담고
				while (rs.next()) {
					list.add(rs.getString("FirstName"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. add attribute
		model.addAttribute("firstNames", list);
		
		// 4. forward
	}
}
