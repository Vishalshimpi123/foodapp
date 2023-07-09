package com.ty.springBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.Productdao;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.exception.ProductIdNotFoundException;

@Service
public class ProductService {

	@Autowired
	private Productdao productdao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product is successfully saved");
		responseStructure.setData(productdao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {
		Product product2 = productdao.updateProduct(id, product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product is updated successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ProductIdNotFoundException("Product Id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		Product product = productdao.deleteProduct(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product is deleted successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ProductIdNotFoundException("Product id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Product product = productdao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Product is get successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ProductIdNotFoundException("Product id is not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProductById(int mid) {
		List<Product> product = productdao.findallproduct(mid);
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		if (product!= null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product is get successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ProductIdNotFoundException("Product id is not found");
		}
	}

}
