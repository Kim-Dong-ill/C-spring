package com.example.demo.dto;

import com.example.demo.Entity.TestEntity;

import lombok.Data;

@Data
public class TestDto {
	private Long id;
	private String title;
	private String content;
	
	public TestDto(){}

	public TestDto(Long id,String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public TestEntity toEntity() {
		return new TestEntity(null,title,content);
	}
}
