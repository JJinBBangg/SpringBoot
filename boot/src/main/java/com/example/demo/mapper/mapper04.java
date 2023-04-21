package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface mapper04 {
	
	@Delete("""
			DELETE FROM MyTable40
			""")
	int sql1();
	
	@Delete("""
			DELETE FROM MyTable40
			WHERE id = #{id}
			""")
	int sql2(Integer id);

	@Delete("""
			DELETE FROM Customers
			WHERE CustomerId = #{id} 
			""")
	int sql3(int id);

}
