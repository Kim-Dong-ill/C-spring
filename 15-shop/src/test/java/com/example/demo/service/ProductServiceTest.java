package com.example.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ProductDTO;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	public void testRegister() {
		ProductDTO productDTO = ProductDTO.builder()
				.pname("새로운 상품")
				.pdesc("새상품설명")
				.price(400000)
				.build();
		
		productDTO.setUploadFileNames(
				java.util.List.of(
						UUID.randomUUID() + "_" +"test1.jpg",
						UUID.randomUUID() + "_" +"test2.jpg"
						)
				);
		
		productService.register(productDTO);
	}
}
