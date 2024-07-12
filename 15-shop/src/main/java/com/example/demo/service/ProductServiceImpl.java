package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
		
//		List<ProductDTO> dtoList = result.get().map(null).toList();
		List<ProductDTO> dtoList = result.get().map(
				arr -> {
					ProductDTO productDTO = null;
					Product product = (Product) arr[0];
					ProductImage productImage = (ProductImage) arr[1];
					
					productDTO = ProductDTO.builder()
							.pno(product.getPno())
							.pname(product.getPname())
							.pdesc(product.getPdesc())
							.price(product.getPrice())
							.build();
					
					String imageStr = productImage.getFileName();
					productDTO.setUploadFileNames(List.of(imageStr));
					
					return productDTO;
					
				})
				.toList();
		
		long totalCount = result.getTotalElements();
		
		return PageResponseDTO.<ProductDTO>withAll()
				.dtoList(dtoList)
				.totalCount(totalCount)
				.pageRequestDTO(pageRequestDTO)
				.build();
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

	//수정
	@Override
	public void modify(ProductDTO productDTO) {
		
		//#1 read
		Optional<Product> result = productRepo.findById(productDTO.getPno());
		Product product = result.orElseThrow();
		
		//#2 change
		product.changeName(productDTO.getPname());
		product.changePrice(productDTO.getPrice());
		product.changePdesc(productDTO.getPdesc());
		
		//#3 upload file clear
		product.clearList();
		
		List<String> uploadFileNames = productDTO.getUploadFileNames();
		
		if(uploadFileNames != null && uploadFileNames.size() > 0) {
			uploadFileNames.stream().forEach(
					uploadName -> {
						product.addImageString(uploadName);
					});
			
		}
		
		//# last
		productRepo.save(product);
		
	}

	@Override
	public void remove(Long pno) {
		// TODO Auto-generated method stub
		
	}
	
}









