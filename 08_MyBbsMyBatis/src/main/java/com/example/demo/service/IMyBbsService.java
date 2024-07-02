package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.MyBbsDTO;

public interface IMyBbsService {
	public List<MyBbsDTO> list();	//다수의 리스트 보여줄때
	public MyBbsDTO view(String id);	//단일 항목 보여줄때
	public int write(String writer,String title, String content);	//글 작성 할때
	public int delete(@Param("_id") String id);	//글 삭제할때
}
