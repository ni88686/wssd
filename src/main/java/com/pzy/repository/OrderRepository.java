package com.pzy.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pzy.entity.Order;
import com.pzy.entity.User;
public interface OrderRepository   extends   MongoRepository< Order, String>{
	public List<Order> findByUser(User user);

	public Page<Order> findByState(String state, Pageable pageRequest);

	public Page<Order> findByCreateDateBetween(Date b, Date e, Pageable pageRequest);
}

