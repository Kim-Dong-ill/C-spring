package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TestEntity;
import com.example.demo.repo.TestRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TestService {

	@Autowired
	private TestRepo testrepo;
	
	public TestEntity create(String name, int age) {
		TestEntity testEntity = new TestEntity(null,name,age);
		
		//TestEntity testEntity = TestEntity.builder().build();
		
		testrepo.save(testEntity);
		return testEntity;
	}
}
