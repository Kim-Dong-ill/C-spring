package com.example.demo.service;

import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.ProductDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
	PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);
	
	Long register(ProductDTO productDTO);
}
