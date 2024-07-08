package com.example.demo.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.api.request.CreateAndEditrestaurantRequest;
import com.example.demo.model.MenuEntity;
import com.example.demo.model.RestaurantEntity;
import com.example.demo.repository.MenuRepo;
import com.example.demo.repository.RestaurantRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // autowired대신 사용하고 final를 붙여서 사용한다.
public class RestaurantService {

	private final RestaurantRepo restRepo;
	private final MenuRepo menuRepo;

//	@Transactional
//	public String createRestaurnat(
//			CreateAndEditrestaurantRequest request
//			) {
////		RestaurantEntity restaurant = new RestaurantEntity();
//		RestaurantEntity restaurant = RestaurantEntity.builder()
//				.name((request.getName())
//				.updatedAt(ZonedDateTime.now())
//				.createdAt(ZonedDateTime.now())
//						.build();
//				
//		restRepo.save(restaurant);
//		
//		request.getMenus().forEach(menu)->{
//			MenuEntity menuEntity =MenuEntity.builder()
//					.restaurantId(restaurant.getId())
//					.name(menu.getName())
//					.price(menu.getPrice())
//					.createdAt(ZonedDateTime.now())
//					.updatedAt(ZonedDateTime.now())
//					.build();
//			menuRepo.save(menuEntity);
//		}
//		
//		return null;
//	}

	@Transactional
	public void editRestaurant(Long restaurantId, CreateAndEditrestaurantRequest request) {
		RestaurantEntity restaurant = restRepo.findById(restaurantId)
				.orElseThrow(() -> new RuntimeException("아이디가 없음"));
		restaurant.changeNameAndAddress(request.getName(), request.getAddress());
		restRepo.save(restaurant);

		// 이전 메뉴 삭제
		List<MenuEntity> menus = menuRepo.findAllByRestaurantId(restaurantId);
		menuRepo.deleteAll(menus);

		// 새로운 메뉴 생성
		request.getMenus().forEach((menu) -> {
			MenuEntity menuEntity = MenuEntity.builder().restuarntId(restaurantId)
//					.name(menu.getName())
					.price(menu.getPrice()).createdAt(ZonedDateTime.now()).updatedAt(ZonedDateTime.now()).build();
			menuRepo.save(menuEntity);
		});
	}

	public void deleteRestaurant(Long restaurantId) {
		RestaurantEntity restaurant = restRepo.findById(restaurantId)
				.orElseThrow(() -> new RuntimeException("아이디가 없음"));
		restRepo.delete(restaurant);

		// 이전 메뉴 삭제
		List<MenuEntity> menus = menuRepo.findAllByRestaurantId(restaurantId);
		menuRepo.deleteAll(menus);
	}
}
