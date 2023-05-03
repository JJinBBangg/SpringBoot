package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper07 {
	
	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			WHERE country IN(
			<foreach collection="list" item="str" separator=", " >
				#{str}
			</foreach>
			)
			</script>
			""")
	Integer sql1(List<String> list);
	
	@Select("""
			<script>
			SELECT *
			FROM Suppliers
			<if test="list != null">
			WHERE country 
			IN(
			<foreach collection="list" item="country" separator=",">
				#{country}
			</foreach>
			)
			</if>
			</script>
			
			""")
	List<Supplier> sql2(List<String> list);
}
