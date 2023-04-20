package com.example.demo.controller;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub17")
public class Controller17 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	// ?id=65&name=서태웅
	@RequestMapping("link1")
	public void method1(int id, String name) throws Exception {
		String sql = """
				UPDATE Suppliers
				SET
					SupplierName = ?
				WHERE SupplierId = ?
				""";
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, name);
			pstmt.setInt(2, id);

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 수정됨");

		}

	}
	// 
	@RequestMapping("link2")
	public void method2(int id, String address) throws Exception {
		String sql = """
				UPDATE Suppliers
				SET
					Address = ?
				WHERE SupplierId = ?
				""";
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, address);
			pstmt.setInt(2, id);
				
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 수정됨");
			
		}
		
	}
	@RequestMapping("link3")
	public void method3(Supplier supplier) throws Exception {
		String sql = """
				UPDATE Suppliers
				SET
					SupplierName = ?,
					ContactName = ?,
					Address = ?,
					City = ?,
					PostalCode = ?,
					Country = ?,
					Phone = ?
				WHERE
					SupplierId = ?
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
//			pstmt.setString(1, supplier.getName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());
//			pstmt.setInt(8, supplier.getId());

			int cnt = pstmt.executeUpdate();
//			System.out.println(supplier.getId() + "번 공급자 수정됨");

		}

	}

	// /sub17/link4?id=65
	@RequestMapping("link4")
	public void method4(int id, Model model) throws Exception {
		String sql = """
				SELECT
					SupplierId,
					SupplierName,
					ContactName,
					Address,
					City,
					PostalCode,
					Country,
					Phone
				FROM Suppliers
				WHERE SupplierId = ?
				""";
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					Supplier supplier = new Supplier();
//					supplier.setId(rs.getInt("supplierId"));
//					supplier.setName(rs.getString("supplierName"));
					supplier.setContactName(rs.getString("contactName"));
					supplier.setAddress(rs.getString("address"));
					supplier.setCity(rs.getString("city"));
					supplier.setPostalCode(rs.getString("postalCode"));
					supplier.setCountry(rs.getString("country"));
					supplier.setPhone(rs.getString("phone"));
					model.addAttribute("supplier", supplier);
				}

			}

		}
	}
	@RequestMapping("link5") //id로 고객 조회
	public void mehtod5(int id, Model model) {
		String sql = """
				SELECT * FROM Customers WHERE CustomerID = ?
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement st = con.prepareStatement(sql)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			Customer customer = new Customer(
//					rs.getInt("CustomerID"),
//					rs.getString("customerName"),
//					rs.getString("contactName"),
//					rs.getString("address"),
//					rs.getString("city"),
//					rs.getString("postalCode"),
//					rs.getString("country")
					);
			model.addAttribute("customer", customer);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("link6")
	public String mehto6(Customer customer) {
		String sql = """
				UPDATE Customers
				SET
					CustomerID = ?,
					customerName = ?,
					contactName = ?,
					address = ?,
					city = ?,
					postalCode = ?,
					country = ?
				WHERE
					CustomerID = ?
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement st = con.prepareStatement(sql)) {
//			st.setInt(1, customer.getId());
//			st.setString(2, customer.getCustomerName());
			st.setString(3, customer.getContactName());
			st.setString(4, customer.getAddress());
			st.setString(5, customer.getCity());
			st.setString(6, customer.getPostalCode());
			st.setString(7, customer.getCountry());
//			st.setInt(8, customer.getId());
			int result = st.executeUpdate();
			System.out.println(result+"개 행 수정됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/sub17/link5";
	}
	
}
