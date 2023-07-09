package com.ty.springBoot_FoodApp.exception;

//custom exception
public class ProductIdNotFoundException extends RuntimeException {

	private String message = "Product id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public ProductIdNotFoundException(String message) {
		super();
		this.message = message;
	}

}
