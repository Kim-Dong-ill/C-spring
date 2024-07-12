package com.example.demo.service;

import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.ProductDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
	PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);
	
	Long register(ProductDTO productDTO);
	
	//리스트 보기
	void modify(ProductDTO productDTO);
	
	//삭제하기
	void remove(Long pno);

	ProductDTO get(Long pno);

}
