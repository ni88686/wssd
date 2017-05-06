package com.pzy.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pzy.entity.Seller;
public interface SellerRepository   extends   MongoRepository< Seller, String>{

	Page<Seller> findByNameLike(String name, Pageable pageRequest);
    
}

