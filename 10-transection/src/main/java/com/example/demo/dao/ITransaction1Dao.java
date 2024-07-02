package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction1Dao {

	public void pay(String cosumerId, int amount);
}
