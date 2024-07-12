package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import com.example.demo.utill.CustomFileUtill;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Log4j2
public class ProductController {

	private final CustomFileUtill fileUtill;
	private final ProductService productService;
	
	@PostMapping("/")
	public Map<String, Long> register(ProductDTO productDto) {
		
		log.info("register : "+productDto);
		
		List<MultipartFile> files = productDto.getFiles();
		List<String> uploadFilenames = fileUtill.saveFiles(files);
		
		productDto.setUploadFileNames(uploadFilenames);
		log.info(uploadFilenames);
		
		Long pno = productService.register(productDto);
		
		return Map.of("Result",pno);
	}
	
	//파일명을 입력했을떄 화면에 파일이 나오게
	@GetMapping("/view/{fileName}")
	public ResponseEntity<Resource> viewFileGet(
			@PathVariable("fileName") String fileName
			){
		
		return fileUtill.getFile(fileName);
	}
	
	//리스트 보기
	@GetMapping("/list")
	public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO){
		return productService.getList(pageRequestDTO);
	}
	
	//수정
	@PutMapping("/{pno}")
	public Map<String,String> modify(
			@PathVariable("pno") Long pno,
			ProductDTO productDTO
			){
		
		productDTO.setPno(pno);
		
		ProductDTO oldProductDTO = productService.get(pno);
		
		//이전 파일 이름들
		List<String> oldFileNames = oldProductDTO.getUploadFileNames();
		
		//새로운 파일 이름들
		List<MultipartFile> files = productDTO.getFiles();
		List<String> currentUploadFileNames = fileUtill.saveFiles(files);
		
		//현제 화면에서 유지된 파일들
		List<String> uploadedFileNames = productDTO.getUploadFileNames();
		
		if(currentUploadFileNames != null && currentUploadFileNames.size() > 0) {
			uploadedFileNames.addAll(currentUploadFileNames);
		}
		
		//수정 작업
		productService.modify(productDTO);
		
		if(oldFileNames != null &&  oldFileNames.size() > 0 ) {
			List<String> removeFiles = oldFileNames.stream()
					.filter(fileName -> uploadedFileNames.indexOf(fileName) == -1)
					.collect(Collectors.toList());
			
			fileUtill.deleteFiles(removeFiles);
		}
		
		return Map.of("Result","success");
	}
	
	@DeleteMapping("/{pno}")
	public Map<String,String> remove(
			@PathVariable("pno") Long pno
			){
		
		List<String> oldFileNames = productService.get(pno).getUploadFileNames();
		
		productService.remove(pno);
		fileUtill.deleteFiles(oldFileNames);
		
		return Map.of("Result","success");
	}
}






