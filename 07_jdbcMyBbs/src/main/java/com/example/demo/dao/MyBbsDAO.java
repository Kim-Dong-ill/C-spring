package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MyBbsDTO;

@Repository
public class MyBbsDAO implements IMyBbsDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//다수 항목
	@Override
	public List<MyBbsDTO> listDao(){
		
		String query = "select * from mybbs1 order by id desc";
		List<MyBbsDTO> dtos = jdbcTemplate.query(query, new BeanPropertyRowMapper(MyBbsDTO.class));
		return dtos;
	}
	
	//단일 항목a
	@Override
	public MyBbsDTO viewDao(String id) {
		String query = "select * from mybbs1 where id ="+id;
		MyBbsDTO dto = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(MyBbsDTO.class));
		return dto;
	}
	
	//삭제할때
	@Override
	public int deleteDao(String id) {
		String query = "delete from mybbs1 where id = ?";
		return jdbcTemplate.update(query,Integer.parseInt(id));
	}
	
	//업데이트 할때
	@Override
	public int writeDao(String writer,String title, String content) {
		String query = "insert into mybbs1 (writer,title,content)"
				+ " values (?,?,?)";
		return jdbcTemplate.update(query,writer,title,content);
	}
}
