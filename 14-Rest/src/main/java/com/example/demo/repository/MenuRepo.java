package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MenuEntity;

@Repository
public interface MenuRepo extends JpaRepository<MenuEntity, Long>{
	public List<MenuEntity> findAllByRestaurantId(Long restaurantId);
}
