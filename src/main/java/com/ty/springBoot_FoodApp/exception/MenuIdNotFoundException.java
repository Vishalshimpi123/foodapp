package com.ty.springBoot_FoodApp.exception;

public class MenuIdNotFoundException extends RuntimeException {

	private String message = "menu id is not found";

	@Override
	public String getMessage() {
		return getMessage();
	}

	public MenuIdNotFoundException(String message) {
		super();
		this.message = message;
	}

}
