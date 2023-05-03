package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper11 {
	
	@Select("""
			SELECT 
				c.CategoryId,
				c.CategoryName,
				c.Description,
				p.ProductName
			FROM Categories c JOIN Products p
			  ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")
	@ResultMap("categoryWithProductNames")
	Category sql(Integer id);
	@Select("""
			SELECT
				c.CategoryId,
				c.CategoryName,
				c.Description,
				p.ProductName,
				p.Price
			FROM Categories c JOIN Products p 
				              ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id} 
			""")
	@ResultMap("categoryResultMap")
	Category sql2(int id);
	
	@Select("""
			SELECT 
				s.supplierId,
				s.supplierName,
				s.contactName,
				s.address,
				s.city,
				s.country,
				p.productName,
				p.price,
				p.categoryId,
				c.CategoryName,
				c.description
			FROM Suppliers s JOIN Products p
							ON s.supplierId = p.supplierId
							JOIN Categories c
							ON p.categoryId = c.categoryId
			WHERE s.supplierId = #{id}
			""")
	@ResultMap("supplierWithProductsAndCategory")
	Supplier sql3(int id);
	
	
	
}
