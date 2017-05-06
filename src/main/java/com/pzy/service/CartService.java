
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pzy.entity.Cart;
import com.pzy.entity.Order;
import com.pzy.repository.CartRepository;

@Service
public class CartService {
	
    @Autowired
    private CartRepository cartRepository;
    public List<Cart> findAll() {
         return (List<Cart>) cartRepository.findAll();
    }
    public List<Cart> findCartSubs() {
        return (List<Cart>) cartRepository.findAll();
    }
    public List<Cart> findCarts() {
        return (List<Cart>) cartRepository.findAll();
    }
    public List<Cart> findByOrder(Order order){
		return cartRepository.findByOrder(order);
	}
    public Page<Cart> findAll(final int pageNumber, final int pageSize,final String state){
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
       return (Page<Cart>) cartRepository.findAll( pageRequest);
    }
    
		public void delete(String id){
			cartRepository.delete(id);
		}
		public Cart findCart(String id){
			  return cartRepository.findOne(id);
		}
		public Cart find(String id){
			  return cartRepository.findOne(id);
		}
		public void save(Cart cart){
			cartRepository.save(cart);
		}
}