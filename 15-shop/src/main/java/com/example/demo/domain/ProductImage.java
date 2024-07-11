package com.example.demo.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductImage {
	private String fileName;
	private int ord;	//순번
	
	public void setOrd(int ord) {
		this.ord = ord;
	}
}
