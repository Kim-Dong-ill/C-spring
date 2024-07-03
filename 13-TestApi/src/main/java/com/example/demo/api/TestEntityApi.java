package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TestEntityApi {
	
	@Autowired
	private TestService service;
	
	@GetMapping("/test/entity/create")
	public void createTestEntity() {
		service.create("han", 34);
	}
}
