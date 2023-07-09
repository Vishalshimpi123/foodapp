package com.ty.springBoot_FoodApp.dao;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.repo.ItemsRepo;

@Repository
public class ItemsDao {
	@Autowired
	private ItemsRepo repo;

	public Items updateItem(int id, Items items) {
		Items items2 = repo.findById(id).get();
		if (items2 != null) {
			items.setItem_id(id);
			repo.save(items);
			return items;
		} else {
			return null;
		}
	}

	public Items deleteItems(int id) {
		Items items = repo.findById(id).get();
		if (items != null) {
			repo.deleteById(id);
			return items;
		} else {
			return null;
		}
	}

	public Items getItemsById(int id) {
		Items items = repo.findById(id).get();
		if (items != null) {
			return items;
		} else {
			return null;
		}

	}

}
