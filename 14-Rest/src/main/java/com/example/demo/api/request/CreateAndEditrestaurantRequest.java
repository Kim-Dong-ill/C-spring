package com.example.demo.api.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CreateAndEditrestaurantRequest {
	public CreateAndEditrestaurantRequest() {};
	private  String name;
	private  String address;
	private  List<CreateAndEditrestaurantMenuRequest> menus;
}
