package com.trainee.crud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.crud.model.CrudModel;
@Repository("crudRepository")
public interface CrudRepository  extends JpaRepository<CrudModel, Long>{

	CrudModel findByEmail(String email);

	List<CrudModel> findByMobileNumber(String mobileNumber);

	List<CrudModel> findByFirstName(String firstName);

	CrudModel save(Optional<CrudModel> crud);

//	List<CrudModel> updateCrud(CrudModel crud);

//	List<CrudModel> findbyName(String name);
    
}
