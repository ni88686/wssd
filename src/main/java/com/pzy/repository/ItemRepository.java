package com.pzy.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pzy.entity.Category;
import com.pzy.entity.Item;
public interface ItemRepository  extends   MongoRepository<Item, String>{
	public List<Item> findByCategory(Category category);

	public Page<Item> findByNameLike(String name, Pageable pageRequest);
}

