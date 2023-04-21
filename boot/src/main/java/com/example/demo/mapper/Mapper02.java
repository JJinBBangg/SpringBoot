package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper02 {
	
	@Select("""
			SELECT * FROM Customers
			""")
	List<Customer> method1();
	
	@Select("""
			SELECT * FROM Products
			""")
	List<Product> method2();
	@Select("""
			SELECT * FROM Products
			WHERE CategoryId = #{id}
			""")
	List<Product> method3(int id);
}
