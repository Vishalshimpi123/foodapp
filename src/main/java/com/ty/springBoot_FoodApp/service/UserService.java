package com.ty.springBoot_FoodApp.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.UserDao;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.exception.UserIdNotFoundException;

@Service // service layer is used to send the data in correct form
public class UserService {

	@Autowired
	private UserDao dao; // for calling the userdao inside the service layer we have to create userdao
							// refer in service layer

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value()); // we sending status code
		responseStructure.setMessage("user successfully saved"); // sending message
		responseStructure.setData(dao.saveUser(user)); // set data that we saving
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User user2 = dao.updateUser(id, user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user is successfully updated");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("user id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User user = dao.deleteUser(id);
		ResponseStructure<User> responseStructure =  new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user is successfully deleted");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("user id is not found");
		}

	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User user = dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("user is get successfully");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementException();
		}

	}
}