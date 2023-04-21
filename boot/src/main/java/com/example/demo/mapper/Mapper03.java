package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface Mapper03 {
	
	@Insert("""
			INSERT INTO Customers(customerName, address)
			VALUES(#{customerName}, #{address})
			""")
	int method1(String customerName, String address);
	
	@Update("""
			UPDATE Customers(customerName, address, contactName, city, postalCode, country)
			VALUES(#{customerName}, #{address}, #{contactName}, #{city}, #{postalCode}, #{country})
			WHERE CustomerId = #{customerID}
			""")
	int method2(Customer customer, int cutomerId);
	
	@Insert("""
			INSERT INTO MyTable34 (Col1, Col2)
			VALUES (#{val1}, #{val2})
			""")
	int sql1(Integer val1, String val2);
	
	// MyTable35 만들기
	// controller22.method2에서 mapper03.sql2 메소드 호출
	@Insert("""
			INSERT INTO MyTable35 (Col1, Col2)
			VALUES (#{v1}, #{v2})
			""")
	int sql2(Double v1, String v2);
	
	
	// 파라미터 1개일 때
	// 프로퍼티명만 작성
	@Insert("""
			INSERT INTO MyTable36 (Col1, Col2, Col3)
			VALUES (#{prop1}, #{prop2}, #{prop3})
			""")
	int sql3(Dto09 dto);
	
	
	// 1)MyTable37 테이블 만들기
	// 2)Dto10 자바빈 만들기
	// 3)mapper03.sql4 메소드를 controller22.method5에서 호출
	@Insert("""
			INSERT INTO MyTable37 (Age, Name, Score)
			VALUES (#{age}, #{name}, #{score})
			""")
	int sql4(Dto10 dto);
	
	
	@Insert("""
			INSERT INTO MyTable37 (Age, Name, Score)
			VALUES (#{dto9.prop1}, #{dto10.name}, #{dto9.prop3})
			""")
	int sql5(Dto09 dto9, Dto10 dto10);
	
	
	// dto1.prop1 -> col1
	// dto2.age -> col2
	// dto1.prop2 -> col3
	// dto2.name -> col4
	// dto1.prop3 -> col5
	// dto2.score -> col6
	// ?부분 코드 수정
	// 이 메소드를 controller22.method9에서 호출
	@Insert("""
			INSERT INTO MyTable38 
				(Col1, Col2, Col3, Col4, Col5, Col6)
			VALUES 
				(#{dto1.prop1}, 
				#{dto2.age}, 
				#{dto1.prop2}, 
				#{dto2.name}, 
				#{dto1.prop3}, 
				#{dto2.score})
			""")
	int sql6(Dto09 dto1, Dto10 dto2);

	
	@Insert("""
			INSERT INTO MyTable39 (Col2, Col3)
			VALUES (#{prop2}, #{prop3})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "prop1")
	int sql7(Dto11 dto);
	
	@Insert("""
			INSERT INTO MyTable40 (age, name, score)
			VALUES (#{age}, #{name}, #{score})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int sql8(Dto12 dto);
	

}
