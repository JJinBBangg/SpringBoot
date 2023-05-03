package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper10 {
	
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

	@Update("""
			UPDATE Bank
			SET money = money - 500
			WHERE name = 'A'
			""")
	void minusA();

	@Update("""
			UPDATE Bank
			SET money = money + 500
			WHERE name = 'B'
			""")
	void plusB();

}
