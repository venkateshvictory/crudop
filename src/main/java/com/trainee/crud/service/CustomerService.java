package com.trainee.crud.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainee.crud.dao.CustomerRepository;
import com.trainee.crud.model.CustomerModel;

@Service("customerService")
public class CustomerService {
	
	@Resource(name="customerRepository")
	private CustomerRepository customerRepository;
	
	
	public Optional<CustomerModel> findByid(Long id) {
		return customerRepository.findById(id);
	}
	
	

}
