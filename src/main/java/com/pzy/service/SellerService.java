
package com.pzy.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pzy.entity.Seller;
import com.pzy.repository.SellerRepository;

@Service
public class SellerService {
	
    @Autowired
    private SellerRepository sellerRepository;
    public List<Seller> findAll() {
         return (List<Seller>) sellerRepository.findAll();
    }
    public List<Seller> findSellerSubs() {
        return (List<Seller>) sellerRepository.findAll();
    }
    public List<Seller> findSellers() {
        return (List<Seller>) sellerRepository.findAll();
    }
    
    public Page<Seller> findAll(final int pageNumber, final int pageSize,final String name){
    	 PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Page<Seller> result ;
         if(!StringUtils.isBlank(name)){
        	 result =  (Page<Seller>) sellerRepository.findByNameLike(name, pageRequest);
         }else{
        	 result =  (Page<Seller>) sellerRepository.findAll( pageRequest);
         }
         return result;
    	}
		public void delete(String id){
			sellerRepository.delete(id);
		}
		public Seller findSeller(String id){
			  return sellerRepository.findOne(id);
		}
		public Seller find(String id){
			  return sellerRepository.findOne(id);
		}
		public void save(Seller seller){
			sellerRepository.save(seller);
		}
}