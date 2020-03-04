package com.start.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.start.springboot.model.Item;
import com.start.springboot.repository.ItemRepository;


@Service
public class ItemDao {

	@Autowired
	ItemRepository itemRepository;

     public List<Item> findAll(){	 
    	 return itemRepository.findAll();
     }

 	public Item findById(Long itemId) {
		return itemRepository.getOne(itemId);
	}
 
 	public List<Item> findSortedItems(String parameter)
	{
		return itemRepository.findAll(Sort.by(parameter));
	}
 
}
