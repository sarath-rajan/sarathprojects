package com.start.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.start.springboot.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {

}
