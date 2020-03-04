package com.start.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.start.springboot.model.Item;
import com.start.springboot.service.ItemService;

@RestController
@RequestMapping("/shop")
public class ItemController {

	@Autowired
	ItemService itemService;

	@GetMapping("/itemsSorted")
	public List<Item> getAllItemsSorted() {
		return itemService.getAllItemsSorted();
	}

	@GetMapping("/items/{id}")
	public String getItembyid(@PathVariable(value = "id") long itemId) {
		return itemService.convertObjectToJson(itemService.findById(itemId));
	}

	@GetMapping("/items/sort")
	public String getItemsSorted() {
		return itemService.convertObjectToJson(itemService.findSortedItems("price"));
	}

	@GetMapping("/{itemIds}")
	public String getPassedItemDetails(@PathVariable String itemIds) {
		return itemService.convertObjectToJson(itemService.getPassedItemDetails(Arrays.asList(itemIds.split(","))));
	}
}
