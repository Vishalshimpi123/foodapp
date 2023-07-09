package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	private MenuRepo repo;

	public Menu saveMenu(Menu menu) {
		return repo.save(menu);
	}

	public Menu updateMenu(int id, Menu menu) {
		Optional<Menu> menu2 = repo.findById(id);
		if (menu2.isPresent()) {
			menu.setMid(id);
			repo.save(menu);
			return menu;
		} else {
			return null;
		}
	}

	public Menu deleteMenu(int id) {
		Optional<Menu> menu = repo.findById(id);
		if (menu.isPresent()) {
			repo.deleteById(id);
			return menu.get();
		} else {
			return null;
		}
	}

	public Menu getMenuById(int id) {
		Optional<Menu> menu = repo.findById(id);
		if (menu.isPresent()) {
			return menu.get();
		} else {
			return null;
		}

	}

}
