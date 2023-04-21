package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper01 {
	@Select("""
			SELECT CustomerName FROM Customer WHERE CustomerID = 1
			""")

	String method1();

	@Select("""
			SELECT * FROM Customers
			""")
	List<Customer> method2();

	@Select("""
			SELECT * FROM Employees
			""")
	List<Employee> method3();

	@Select("""
			SELECT * FROM Suppliers
			""")
	List<Supplier> method4();

	@Select("""
			SELECT * FROM Customers
			WHERE CustomerID = #{id}
			""")
	Customer method5(Integer id);
	
	@Select("""
			SELECT * FROM Employees
			WHERE EmployeeID = #{id}
			""")
	Employee method6(Integer id);
	
	
	// 페이징 처리
	@Select("""
			<script>
			SELECT * FROM Customers
			<if test='id != null and !id.equals("")'>
				AND #{} LIKE '%#{}%'
			</if>
			</script>
			""")
	Customer method7(String id,String culomn, String search);
	
}
