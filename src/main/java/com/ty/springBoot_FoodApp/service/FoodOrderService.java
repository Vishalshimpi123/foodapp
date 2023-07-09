package com.ty.springBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.FoodOrderDao;
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.exception.FoodOrderIdNotFoundException;

@Service // service layer is used for writing business logic
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		List<Items> list = foodOrder.getItems();
		double totalprice = 0;
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		// for-each loop
		for (Items items : list) {
			totalprice += items.getCost() * items.getQuantity(); // for writing bussiness login in service layer
			foodOrder.setTotalprice(totalprice);
		}
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("FoodOrder is save successfully");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int id, FoodOrder foodOrder) {
		FoodOrder foodOrder2 = dao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder2 != null) {
			List<Items> list = foodOrder.getItems();
			double totalprice = 0;
			for (Items items : list) {
				totalprice += items.getCost() * items.getQuantity();
			}
			foodOrder.setTotalprice(totalprice); //
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Foodorder is updates successfully");
			responseStructure.setData(dao.updateFoodOrder(id, foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFoundException("food order is not found");
		}

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		FoodOrder foodOrder = dao.deleteFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("FoodOrder deleted successfully");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		FoodOrder foodOrder = dao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FoodOrder is get successfully");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.FOUND);
		} else {
			return null;
		}

	}
}
