package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.utill.CustomFileUtill;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Log4j2
public class ProductController {

	private final CustomFileUtill fileUtill;
	
	@PostMapping("/")
	public Map<String, String> register(ProductDTO productDto) {
		
		log.info("register : "+productDto);
		
		List<MultipartFile> files = productDto.getFiles();
		List<String> uploadFilenames = fileUtill.saveFiles(files);
		
		productDto.setUploadFileNames(uploadFilenames);
		log.info(uploadFilenames);
		
		return Map.of("Result","success");
	}
	
	//파일명을 입력했을떄 화면에 파일이 나오게
	@GetMapping("/view/{fileName}")
	public ResponseEntity<Resource> viewFileGet(
			@PathVariable("fileName") String fileName
			){
		
		return fileUtill.getFile(fileName);
	}
	
}






