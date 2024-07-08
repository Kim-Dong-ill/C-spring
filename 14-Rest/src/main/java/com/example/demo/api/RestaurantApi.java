package com.example.demo.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.request.CreateAndEditrestaurantRequest;

@RestController
public class RestaurantApi {

	@GetMapping("/restaurants")
	public String getRestaurants() {
		return "getRestaurants";
	}
	
	@GetMapping("/restaurants/{restaurantId}")
	public String getRestaurant(
			@PathVariable("restaurantId") Long restaurantId
			) {
		return "getRestaurant id : "+restaurantId;
	}
	
	@PostMapping("/restaurants")
	public String createRestaurant(
			@RequestBody CreateAndEditrestaurantRequest request
			) {
		return "createRestaurant name : " +request.getName() 
		+ ", address : "+ request.getAddress()
		+ ", menu[0].name : "+request.getMenus().get(0).getName()	//menus의 0번째의 name을 가져온다.
		+ ", menu[1].name : "+request.getMenus().get(1).getName();
	}
	
	@PutMapping("/restaurants/{restaurantId}")
	public String editRestaurant(
			@PathVariable("restaurantId") Long restaurantId,
			@RequestBody CreateAndEditrestaurantRequest request
			) {
		return "editRestaurant id : "+ restaurantId + "name : " +request.getName() 
		+ ", address : "+ request.getAddress()
		+ ", menu[0].name : "+request.getMenus().get(0).getName()	//menus의 0번째의 name을 가져온다.
		+ ", menu[1].name : "+request.getMenus().get(1).getName();
	}
	
	@DeleteMapping("/restaurants/{restaurantId}")
	public String deleteRestuarnat(
			@PathVariable("restaurantId") Long restaurantId,
			@RequestBody CreateAndEditrestaurantRequest request
			) {
		return "deleteRestaurant id : "+ restaurantId + "name : " +request.getName() 
		+ ", address : "+ request.getAddress()
		+ ", menu[0].name : "+request.getMenus().get(0).getName()	//menus의 0번째의 name을 가져온다.
		+ ", menu[1].name : "+request.getMenus().get(1).getName();
	}
}

