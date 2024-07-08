package com.example.demo.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="restaurant")
public class RestaurantEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column(name="created_at")
	private ZonedDateTime createdAt;
	
	@Column(name="updated_at")
	private ZonedDateTime updatedAt;

	public void changeNameAndAddress(String name2, String address2) {
		this.name = name2;
		this.address = address2;
		this.updatedAt = ZonedDateTime.now();
	}
}
