package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_product")
@Getter
@Builder
@ToString(exclude="imageList")//db에 왔다갔다 할때 imageList단어가 들어간 뭔가를 제외한다.
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	private String pname;
	private int price;
	private String pdesc;
	private boolean delFlag;
	
	//이게 알아서 ProductImage와 fk를 잡아준다 pno와 ProductImage에서 컬럼 하나 만들어서 연결시켜줌 
	@ElementCollection
	@Builder.Default
	private List<ProductImage> imageList = new ArrayList<>();
	
	public void addImage(ProductImage image) {
		image.setOrd(this.imageList.size());
		imageList.add(image);
	}
	public void addImageString(String fileName) {
		ProductImage productImage = ProductImage.builder()
				.fileName(fileName)
				.build();
		addImage(productImage);
	}
	
	
	public void changeName(String name) {
		this.pname = name;
	}
	
	public void changePrice(int price) {
		this.price = price;
	}
	
	public void changePdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	public void changeDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
	
}












