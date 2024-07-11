package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductImage;
import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
@Log4j2
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepo;
	
	@Override
	public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
		
		Pageable pageable = PageRequest.of(pageRequestDTO.getPage()-1,
				pageRequestDTO.getSize(),
				Sort.by("pno").descending());
		
		Page<Object[]> result = productRepo.selectList(pageable);
		
		return null;
	}

	@Override
	public Long register(ProductDTO productDTO) {
		
		Product product = dtoToEntity(productDTO);
		
		log.info("==============================");
		log.info(product);
		log.info(product.getImageList());
		
		Long pno = productRepo.save(product).getPno();
		
		return null;
	}

	private Product dtoToEntity(ProductDTO productDTO) {
		Product product = Product.builder()
				.pno(productDTO.getPno())
				.pname(productDTO.getPname())
				.pdesc(productDTO.getPdesc())
				.price(productDTO.getPrice())
				.build();
		
		List<String> uploadFileNames = productDTO.getUploadFileNames();
		
		if(uploadFileNames == null || uploadFileNames.isEmpty()) {
			return product;
		}
		
		uploadFileNames.forEach(fileName -> {
			product.addImageString(fileName);
		});
		
		
		return product;
	}
	
}









