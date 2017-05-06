
package com.pzy.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pzy.entity.MsgBox;
import com.pzy.repository.MsgBoxRepository;

@Service
public class MsgBoxService {
	
    @Autowired
    private MsgBoxRepository msgBoxRepository;
    public List<MsgBox> findAll() {
         return (List<MsgBox>) msgBoxRepository.findAll();
    }
    public List<MsgBox> findMsgBoxSubs() {
        return (List<MsgBox>) msgBoxRepository.findAll();
    }
    public List<MsgBox> findMsgBoxs() {
        return (List<MsgBox>) msgBoxRepository.findAll();
    }
    
    public Page<MsgBox> findAll(final int pageNumber, final int pageSize,final String name){
    	  PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
	         Page<MsgBox> result ;
	         if(!StringUtils.isBlank(name)){
	        	 result =  (Page<MsgBox>) msgBoxRepository.findByTitleLike(name, pageRequest);
	         }else{
	        	 result =  (Page<MsgBox>) msgBoxRepository.findAll( pageRequest);
	         }
	         return result;
    	}
		public void delete(String id){
			msgBoxRepository.delete(id);
		}
		public MsgBox findMsgBox(String id){
			  return msgBoxRepository.findOne(id);
		}
		public MsgBox find(String id){
			  return msgBoxRepository.findOne(id);
		}
		public void save(MsgBox msgBox){
			msgBoxRepository.save(msgBox);
		}
}