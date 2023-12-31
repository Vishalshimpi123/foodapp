package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springBoot_FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

	@Query("select m from Menu m where m.mname=?1") // get menu by menu name
	public  Menu getMenuByMenuname(String mname); // abstract method
}
