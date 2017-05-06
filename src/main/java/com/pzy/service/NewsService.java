
package com.pzy.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pzy.entity.News;
import com.pzy.repository.NewsRepository;
/***
 * 
 * @author qq:263608237
 *
 */
@Service
public class NewsService {
     @Autowired
     private NewsRepository newsRepository;

 	public List<News> findTop3() {
 		return newsRepository.findAll(
 				new PageRequest(0, 5, new Sort(Direction.DESC, "createDate")))
 				.getContent();
 	}
     public List<News> findAll() {
         return (List<News>) newsRepository.findAll();
     }
     public Page<News> findAll(final int pageNumber, final int pageSize,final String name){
    	 PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Page<News> result ;
         if(!StringUtils.isBlank(name)){
        	 result =  (Page<News>) newsRepository.findByTitleLike(name, pageRequest);
         }else{
        	 result =  (Page<News>) newsRepository.findAll( pageRequest);
         }
         return result;
     	}
     
     public Page<News> findAll(final int pageNumber, final int pageSize,final Integer type ){
    	 PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Page<News> result ;
         if(type!=null){
        	 result =  (Page<News>) newsRepository.findByType(type, pageRequest);
         }else{
        	 result =  (Page<News>) newsRepository.findAll( pageRequest);
         }
         return result;
     	}
		public void delete(String id){
			newsRepository.delete(id);
		}
		public News find(String id){
			  return newsRepository.findOne(id);
		}
		public void save(News news){
			newsRepository.save(news);
		}
}