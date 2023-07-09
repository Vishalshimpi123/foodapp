package com.ty.springBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController // we used here restAPI and controller layer is act like main method
@RequestMapping("/user") // instead of using separate api we create one api for class
public class UserController {

	@Autowired
	private UserService service; // we used service layer in controller layer
	// save user

	@ApiOperation(value = "Save User", notes = "API is used to save user for given user id") // for which purpose this
																								// API is used
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"), // user is saved then show this
			@ApiResponse(code = 400, message = "id not found for the given user id") }) // if user is not saved then
																						// show this
	@PostMapping // for checking validation
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}

	// update user
	@ApiOperation(value = "Update User", notes = "API is used to update the user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "id not found for the given user id") })

	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @PathVariable int id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	// delete user
	@ApiOperation(value = "Delete User", notes = "API is used to delete the user for the given user id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "id not found for the given user id") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@Valid @PathVariable int id) {
		return service.deleteUser(id);

	}

	// get user by id
	@ApiOperation(value = "Get User By id", notes = "API is used to get the user by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "user id is found"),
			@ApiResponse(code = 404, message = "user id not found") })

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@Valid @PathVariable int id) {
		return service.getUserById(id);
	}

}