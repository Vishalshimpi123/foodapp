package com.ty.springBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.service.MenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService service;

	@ApiOperation(value = "save menu", notes = "API is used to save menu for given id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully save"),
			@ApiResponse(code = 400, message = "id not found") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}

	@ApiOperation(value = "update menu", notes = "API is used to update menu for given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully update"),
			@ApiResponse(code = 404, message = "id is not found for given menu id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int id, @RequestBody Menu menu) {
		return service.updateMenu(id, menu);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@PathVariable int id) {
		return service.deleteMenu(id);
	}

	@GetMapping("/getMenuById")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int id) {
		return service.getMenuById(id);
	}

}