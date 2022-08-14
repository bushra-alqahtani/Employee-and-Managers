package com.codingdojo.mvc.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.model.EmModel;
import com.codingdojo.mvc.repo.EmRepo;

	

	@Service
public class EmService {
		
		@Autowired
		private EmRepo emRepo;
		
		//=========================Find All=====================================
		public List<EmModel> findAll() {
			return emRepo.findAll();
		}
		//=========================Find By Id=====================================
		
		public EmModel findById(Long id) {
			
			 Optional<EmModel> empOptional = emRepo.findById(id);
			 if(empOptional.isPresent()) {
				 return empOptional.get();
			 }
			 
			 return null;
		}
		
		
		//============Implement a getter method that will allow an employee to get their manager.====================
		public List<EmModel>  findManagers(){
			List<EmModel> managers = new ArrayList<EmModel>();
			List<EmModel> all = emRepo.findAll();
			
			for(int i=0 ;i<all.size();i++) {
				if(all.get(i).getManager() == null) {
					managers.add(all.get(i));
				}
			}
			return managers;
		}
		//============Implement a getter method that will allow a manager to get all their employees.==============
		public List<EmModel>  findEmployees(){
			List<EmModel> employeesNotMangers = new ArrayList<EmModel>();
			List<EmModel> all = emRepo.findAll();
			
			for(int i=0 ;i<all.size();i++) {
				if(all.get(i).getManager()!=null) {
					employeesNotMangers.add(all.get(i));
				}
			}
			return employeesNotMangers;
		}
	

	
	}
	