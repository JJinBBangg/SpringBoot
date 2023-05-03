package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface Mapper06 {

	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			<where>
				<if test="id lte 5">
				
				</if>
			</where>
			</script>
			""")
	public Integer sql1();
	
	@Select("""
			SELECT COUNT(*)
			FROM Customers
			WHERE CustomerId < #{id}
			
			""")
	public Integer sql2();
	
	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			
			WHERE CustomerId &lt; #{id}
			
			</script>
			""")
	public Integer sql3();
	@Select("""
			<script>
			<![CDATA[
			SELECT COUNT(*)
			FROM Customers
			WHERE CustomerId < #{id}
			]]>
			<where>
				<if test="true">
				<![CDATA[
					OR CustomerId < #{id}
				]]>
				</if>
			</where>
			</script>
			""")
	public Integer sql4();
}
