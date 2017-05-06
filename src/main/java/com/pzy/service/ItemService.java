package com.pzy.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pzy.entity.Category;
import com.pzy.entity.Item;
import com.pzy.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	
	public Page<Item> findAll(final int pageNumber, final int pageSize,final String name) {
		  PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
	         Page<Item> result ;
	         if(!StringUtils.isBlank(name)){
	        	 result =  (Page<Item>) itemRepository.findByNameLike(name, pageRequest);
	         }else{
	        	 result =  (Page<Item>) itemRepository.findAll( pageRequest);
	         }
	         return result;
	}
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	public Item find(String id) {
		return itemRepository.findOne(id);
	}

	public void delete(String id) {
		Item item=this.itemRepository.findOne(id);
		itemRepository.delete(id);
	}

	public List<Item> findHot() {
		return itemRepository.findAll(
				new PageRequest(0, 6, new Sort(Direction.ASC, "count")))
				.getContent();
	}

	public List<Item> findNew() {
		return itemRepository.findAll(
				new PageRequest(0, 6, new Sort(Direction.DESC, "createDate")))
				.getContent();
	}
	public List<Item> findByCategory( Category category) {
		return itemRepository.findByCategory(category);
	}
}