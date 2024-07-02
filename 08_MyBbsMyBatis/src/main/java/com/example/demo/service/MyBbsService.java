package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMyBbsDAO;
import com.example.demo.dto.MyBbsDTO;

@Service
public class MyBbsService implements IMyBbsService{
	
	@Autowired
	IMyBbsDAO dao;
	
	@Override
	public List<MyBbsDTO> list(){
		return dao.listDao();
	}
	
	@Override
	public MyBbsDTO view(String id) {
		return dao.viewDao(id);
	}
	
	@Override
	public int write(String writer,String title, String content) {
		return dao.writeDao(writer, title, content);
	}
	
	@Override
	public int delete(@Param("_id") String id) {
		return dao.deleteDao(id);
	}
}
