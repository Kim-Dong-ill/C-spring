package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class TestResponseApi {

	@GetMapping("/test/response/string")
	public String response() {
		return "hello";
	}
	
//	@GetMapping("/test/response/json")
//	public String jsonResponse() {
//		return "{\"message\":\"hello\"}";
//	}
	
	@GetMapping("/test/response/json")
	public TestResponseBody jsonResponse() {
		return new TestResponseBody("han",32); 	
	}
	
//	@Data
//	public static class TestResponseBody {
//		String name;
//		int age;
//		
//		public TestResponseBody(String name, int age) {
//			this.name = name;
//			this.age = age;
//		}
//	}

	
}
