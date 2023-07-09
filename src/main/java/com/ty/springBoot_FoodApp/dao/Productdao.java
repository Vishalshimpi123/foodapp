package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.repo.ProductRepo;

@Repository
public class Productdao {
// whenever u have to changes in product seperatly so that purpose we create seperate dao layer for product

	@Autowired
	private ProductRepo repo;

	@Autowired
	private MenuDao dao;

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	public Product updateProduct(int id, Product product) {
		Optional<Product> product2 = repo.findById(id);
		if (product2.isPresent()) {
			product.setPid(id);
			repo.save(product);
			return product;
		} else {
			return null;
		}
	}

	public Product deleteProduct(int id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			repo.deleteById(id);
			return product.get();
		} else {
			return null;
		}

	}

	public Product getProductById(int id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}

	}

	public List<Product> findallproduct(int mid) {
		List<Product> products = repo.findAll();
		if (products != null) {
			return products;
		} else {
			return null;
		}
	}

}
