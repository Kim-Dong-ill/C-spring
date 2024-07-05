package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

import lombok.Getter;

@RestController
public class TestRequestApi {
	
	@Autowired
	TestService ts;

	//param
	@GetMapping("/test/param")	//test/param?name=홍길동&age=51
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			Model model
			) {
		return "requestParm name : "+name + "/"+age;
	}
	
	//path
	@GetMapping("/test/path/{name}/{age}")
	public String requestPath(
			@PathVariable("name") String name,
			@PathVariable("age") int age
			) {
		return "requestPath name : "+name + "/" + age;
	}
	
	//request body
	@PostMapping("/test/body")
	public String requestBody(
			@RequestBody TestRequestDto trb
			) {
		
		return "requestBody name : "+trb.name + "/" + trb.age;
	}
	
//	@PostMapping("/test/body")
//	public String requestBody(
//			@RequestBody TestRequestBody trb
//			) {
//		
//		return "requestBody name : "+trb.name + "/" + trb.age;
//	}
	
	@Getter
	public static class TestRequestBody{
		String name;
		int age;
		
		public TestRequestBody() {}
		
		public TestRequestBody(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(
			@PathVariable("id") Long id
			) {
		ts.delete(id);
	}
	
	@PutMapping("/test/entity/{id}")
	public void putTestEntity(
			@PathVariable("id") Long id,
			@RequestBody TestRequestDto dto
			) {
		ts.update(id,dto.getName(),dto.getAge());
		
	}
}
