package com.example.demo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Iterable<MyDTO> list() {
		String query = "SELECT * from mybbs1 order by id desc";
		List<MyDTO> list = jdbcTemplate.query(
					query, new BeanPropertyRowMapper<>(MyDTO.class)
				); 
		return list;
	}
}
