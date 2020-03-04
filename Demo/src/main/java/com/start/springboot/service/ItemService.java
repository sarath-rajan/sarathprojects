package com.start.springboot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.start.springboot.dao.ItemDao;
import com.start.springboot.model.Item;

@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;

	public Item findById(long itemId) {
		return itemDao.findById(itemId);
	}

	public List<Item> findSortedItems(String parameter) {
		return itemDao.findSortedItems(parameter);
	}

	public List<Item> getPassedItemDetails(List<String> itemIds) {
		List<Item> items = new ArrayList<Item>();
		for (String itemId : itemIds) {
			items.add(itemDao.findById(Long. parseLong(itemId)));
		}
		return items;
	}

	public List<Item> getAllItemsSorted() {
		List<Item> items = itemDao.findAll();
		List<Item> resultItems = new ArrayList<Item>();
        resultItems = items.stream().filter(s -> s.getBrand().toUpperCase().startsWith("T")).collect(Collectors.toList());
        Collections.sort(resultItems , (i1,i2) -> i2.getPrice() - i1.getPrice());
		return resultItems;
	}

	public String convertObjectToJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
		}
		return json;
	}

}
