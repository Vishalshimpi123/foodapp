package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.springBoot_FoodApp.dao.ItemsDao;
import com.ty.springBoot_FoodApp.dto.Items;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;

	
	public Items updateItems(int id, Items items) {
		Items items2 = dao.updateItem(id, items);
		if (items2 != null) {
			return items;
		} else {
			return null;
		}
	}

	public Items deleteItems(int id) {
		Items items = dao.deleteItems(id);
		return items;
	}

	public Items getItemsById(int id) {
		Items items = dao.getItemsById(id);
		return items;
	}

}
