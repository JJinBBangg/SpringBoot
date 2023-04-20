package com.example.demo.entity;

import java.sql.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class Notice {
	private long id;
	private String title;
	private String writerId;
	private String Content;
	private Date regdate;
	private int hit;
	private String files;
	private int pub;
	
}
