package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.MyBbsDTO;

@Mapper
public interface IMyBbsDAO {
	public List<MyBbsDTO> listDao();	//다수의 리스트 보여줄때
	public MyBbsDTO viewDao(String id);	//단일 항목 보여줄때
	public int writeDao(String writer,String title, String content);	//글 작성 할때
	public int deleteDao(@Param("_id") String id);	//글 삭제할때
}
