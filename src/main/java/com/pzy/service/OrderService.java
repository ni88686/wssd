
package com.pzy.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pzy.entity.Order;
import com.pzy.entity.User;
import com.pzy.repository.OrderRepository;

@Service
public class OrderService {
	
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAll() {
         return (List<Order>) orderRepository.findAll();
    }
    public List<Order> findOrderSubs() {
        return (List<Order>) orderRepository.findAll();
    }
    public List<Order> findOrders() {
        return (List<Order>) orderRepository.findAll();
    }
    public List<Order> findByUser(User user){
		return orderRepository.findByUser(user);
	}
    public Page<Order> findAll(final int pageNumber, final int pageSize,final String state){
    	 PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Page<Order> result ;
         if(!StringUtils.isBlank(state)){
        	 result =  (Page<Order>) orderRepository.findByState(state, pageRequest);
         }else{
        	 result =  (Page<Order>) orderRepository.findAll( pageRequest);
         }
         return result;
    	}
    
    /***
     * todo
     * @param pageNumber
     * @param pageSize
     * @param b
     * @param e
     * @return
     */
    public Page<Order> findAll(final int pageNumber, final int pageSize,final Date b,final Date e){
    	 PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Page<Order> result ;
         if(b!=null&&e!=null){
        	 result =  (Page<Order>) orderRepository.findByCreateDateBetween(b,e, pageRequest);
         }else{
        	 result =  (Page<Order>) orderRepository.findAll( pageRequest);
         }
         return result;
    	}
		public void delete(String id){
			orderRepository.delete(id);
		}
		public Order findOrder(String id){
			  return orderRepository.findOne(id);
		}
		public Order find(String id){
			  return orderRepository.findOne(id);
		}
		public void save(Order order){
			orderRepository.save(order);
		}
}