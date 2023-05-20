package com.trainee.crud.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.trainee.crud.dao.CrudRepository;
import com.trainee.crud.exceptions.MobileNumberNotValidException;
import com.trainee.crud.model.CrudModel;

@Service("crudService")
public class CrudService {

	@Resource(name="crudRepository")
	private CrudRepository crudRepository;
	
	
	
	public CrudModel save(@RequestBody CrudModel model) {
		Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		Matcher match = ptrn.matcher(model.getMobileNumber());
		if (match.find()  && match.group().equals(model.getMobileNumber())) {
			return crudRepository.save(model);
		} else {
			throw new MobileNumberNotValidException("Mobile number not valid");
		}
		
	}
//	public List<CrudModel> findByName(String name) {
//		return crudRepository.findbyName(name);
//	}
	
	public CrudModel findUsingEmail(String email) {
		return crudRepository.findByEmail( email);
	}
	
	public List<CrudModel> findByMobileNumber(String mobileNumber) {
		return crudRepository.findByMobileNumber(mobileNumber);
	}
	
	public List<CrudModel> findByFirstName(String firstName){
		return crudRepository.findByFirstName(firstName);
	}
	
	public List<CrudModel> findAll (){
		return crudRepository.findAll();
	}
	
//	public List<CrudModel> updateName(Long id, CrudModel crudModel){
//		CrudModel crud = new CrudModel();
//		crud.setFirstName(crud.getFirstName());
//		return crudRepository.updateCrud(crud);
//	}
}
