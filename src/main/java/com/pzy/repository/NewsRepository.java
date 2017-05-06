package com.pzy.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pzy.entity.News;
public interface NewsRepository  extends   MongoRepository< News, String>{

	Page<News> findByTitleLike(String name, Pageable pageRequest);

	Page<News> findByType(Integer type, Pageable pageRequest);
}

