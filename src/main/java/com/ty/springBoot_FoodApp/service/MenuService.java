package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.MenuDao;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.exception.MenuIdNotFoundException;
import com.ty.springBoot_FoodApp.exception.ProductIdNotFoundException;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Menu is save successfully");
		responseStructure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int id, Menu menu) {
		Menu menu2 = dao.updateMenu(id, menu);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Menu is updated successfully");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFoundException("Product id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
		Menu menu = dao.deleteMenu(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu!= null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Menu is deleted successfully");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFoundException("menu id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {
		Menu menu = dao.getMenuById(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Menu is get successfully");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new MenuIdNotFoundException("menu id is not found");
		}
	}

}
