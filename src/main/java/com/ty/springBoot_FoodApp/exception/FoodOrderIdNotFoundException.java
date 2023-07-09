package com.ty.springBoot_FoodApp.exception;

public class FoodOrderIdNotFoundException extends RuntimeException {

	private String message = "Food order id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public FoodOrderIdNotFoundException(String message) {
		super();
		this.message = message;
	}

}
