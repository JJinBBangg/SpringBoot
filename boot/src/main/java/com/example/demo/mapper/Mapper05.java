package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper05 {

	@Update("""
			UPDATE Mytable40
			SET
			name = #{name},
			age = #{age},
			score = #{score},
			WHERE id = #{id},
			""")
	int sql1(Dto12 dto);
	@Update("""
			UPDATE Customers 
			SET
				customerId = #{customerId},
				customerName = #{customerName},
				address = #{address},
				contactName = #{contactName},
				city = #{city},
				postalCode = #{postalCode},
				country = #{country}
			WHERE customerId = #{customerId}
					""")
	int sql2(Customer customer);
	
	@Select("""
			SELECT * FROM Customers
			WHERE CustomerId= #{customerId}
			""")
	Customer sql3(Customer customer);


}
