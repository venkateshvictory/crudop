package com.trainee.crud.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.crud.dao.CustomerRepository;
import com.trainee.crud.model.CustomerModel;
import com.trainee.crud.service.CustomerService;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {

	@Resource(name = "customerRepository")
	private CustomerRepository customerRepository;

	@Resource(name="customerService")
	private CustomerService customerService;
	 
	@PostMapping("/create")
	public CustomerModel save(@RequestBody CustomerModel customerModel) {

		return customerRepository.save(customerModel);
	}
	
//	@GetMapping("/{find}")
//	public CustomerModel findById(@PathVariable("find") Long id) {
//		
//	      Optional<CustomerModel> model=customerRepository.findById(id);
//	      if(model.isPresent()) {
//	    	  model.get();
//	      }
//		return null;
//	}
	
	@GetMapping("/{find}")
	public Optional<CustomerModel> findByid(@PathVariable("find") Long id) {
		return customerRepository.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerModel> update(@PathVariable("id") Long id, @RequestBody CustomerModel customerModel ) {
	
	Optional<CustomerModel>	model=customerService.findByid(id);
     
		if(model.isPresent()) {
			model.get().setEmail(customerModel.getEmail());
			model.get().setFirstName(customerModel.getFirstName());
			model.get().setLastName(customerModel.getLastName());
			model.get().setPhoneNumber(customerModel.getPhoneNumber());
			return new ResponseEntity<CustomerModel>(customerRepository.save(model.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<CustomerModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/delete")
	public void delete (Long id) {
		customerRepository.deleteById(id);
	}
	
	
}
