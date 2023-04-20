package com.example.demo.controller;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub13")
public class Controller13 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) {
		String sql = """
				SELECT CustomerID, CustomerName FROM Customers WHERE CustomerID < 4 
				""";
		List<Customer> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("customerList", list);
	}
	@RequestMapping("link2")
	public void method2(Model model) {
		String sql = """
				SELECT EmployeeId, LastName, FirstName FROM Employees 
				""";
		List<Employee> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while(rs.next()) {
			Employee employee = new Employee(
//					rs.getInt("employeeId"),
//					rs.getString("LastName"),
//					rs.getString("FirstName"),
//					rs.getDate("birthDate"),
//					rs.getString("photo"),
//					rs.getString("notes")
					);
			list.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		model.addAttribute("employeeList", list);
	}
	@RequestMapping("link3")
	public void method3(Model model) {
		String sql = """
				SELECT * FROM Customers
				""";
		List<Customer> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("customerList", list);
	}
	@RequestMapping("link4")
	public void method4(Model model, String id) {
		String sql = """
				SELECT * FROM Customers WHERE CustomerID = ?
				""";
		List<Customer> list = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("customerList", list);
	}
	@RequestMapping("link5")
	public void method5(Model model,@RequestParam(required = false) int id) {
		String sql = """
				SELECT * FROM Employees WHERE EmployeeID = ?
				""";
		List<Employee> list = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement st = con.prepareStatement(sql)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee(
//						rs.getInt("employeeId"),
//						rs.getString("LastName"),
//						rs.getString("FirstName"),
//						rs.getDate("birthDate"),
//						rs.getString("photo"),
//						rs.getString("notes")
						);
				list.add(employee);
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("employeeList", list);
	}
	
}
