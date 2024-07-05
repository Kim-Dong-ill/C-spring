package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TestEntity;
import com.example.demo.repo.TestRepo;

import jakarta.persistence.EntityNotFoundException;
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
	
	public void delete(Long id) {
		TestEntity testEntity = testrepo.findById(id).get();
		testrepo.delete(testEntity);
	}

	public void update(Long id, String name, int age) {
		TestEntity testEntity = 
				testrepo.findById(id).orElseThrow(()->
				new EntityNotFoundException("아이디 없음"));
		testEntity.changeNameAndAge(name,age);
	}
}
