package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper08 {
	
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

}
