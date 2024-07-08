package com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndEditrestaurantMenuRequest {
	private  String name;
	private  int price;
}
