package com.ty.springBoot_FoodApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.val;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@ApiOperation(value = "save product", notes = "API is used to save product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully save"),
			@ApiResponse(code = 400, message = "id is not found") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@Valid @RequestBody Product product) {
		return service.saveProduct(product);
	}

	@ApiOperation(value = "update product", notes = "API is used to update product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "id is not found for given product id") })
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@PathVariable int id,
			@RequestBody Product product) {
		return service.updateProduct(id, product);
	}

	@ApiOperation(value = "delete product", notes = "API is used to delete product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "id not found for given product id") })

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	@ApiOperation(value = "Get product by id", notes = "API is used to Get product for given product id")
	@ApiResponses(value = {@ApiResponse(code = 302, message = "Product id is found"),
			@ApiResponse(code = 404, message = "Product id not found")
	})
	@GetMapping("/getProductById")
	private ResponseEntity<ResponseStructure<Product>> getProById(@RequestParam int id) {
		return service.getProductById(id); 
	}
	@ApiOperation(value = "Get ALL product", notes = "API is used to Get all product")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Product is found" ),
			@ApiResponse(code = 404, message = "Product is not found")
	})
	@GetMapping("/getAllProduct")
	private ResponseEntity<ResponseStructure<List<Product>>> getAllProdcut(@RequestParam int id) {
		return service.getAllProductById(id);
	}
}
