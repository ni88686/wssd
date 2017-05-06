package com.pzy.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pzy.entity.Cart;
import com.pzy.entity.Order;
public interface CartRepository  extends   MongoRepository<Cart, String>{
	public List<Cart> findByOrder(Order order);
}

