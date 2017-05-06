package com.pzy.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pzy.entity.MsgBox;
public interface MsgBoxRepository extends   MongoRepository<MsgBox, String>{

	Page<MsgBox> findByTitleLike(String name, Pageable pageRequest);
}

