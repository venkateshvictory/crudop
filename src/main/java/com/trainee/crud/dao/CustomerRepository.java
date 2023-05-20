package com.trainee.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.crud.model.CustomerModel;
@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

}
