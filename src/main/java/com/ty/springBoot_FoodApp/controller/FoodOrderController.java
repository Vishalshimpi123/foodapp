package com.ty.springBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.service.FoodOrderService;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;

	@PostMapping("/saveFoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}

	@PutMapping("/updateFoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestParam int id, @RequestBody FoodOrder foodOrder) {
		return service.updateFoodOrder(id, foodOrder);
	}

	@DeleteMapping("/deleteFoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>>  deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}

	@GetMapping("/getFoodorderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@RequestParam int id) {
		return service.getFoodOrderById(id);
	}

}
