package com.trainee.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.crud.customer.dto.CrudDto;
import com.trainee.crud.customer.dto.ResponseDto;
import com.trainee.crud.dao.CrudRepository;
import com.trainee.crud.exceptions.MobileNumberNotValidException;
import com.trainee.crud.model.CrudModel;
import com.trainee.crud.service.CrudService;

@RestController
@RequestMapping("/api")
public class CrudController extends BaseController{

	@Resource(name="crudService")
	private CrudService crudService;
	
	@Resource(name="crudRepository")
	private CrudRepository crudRepository;
	
	private ModelMapper modelMapper;
	
	@PostMapping("/create")
	public CrudDto save(@RequestBody CrudModel model) {
		try {
	          CrudModel crudModel=crudService.save(model);
	         return (CrudDto) converToDto(crudModel);
	
		} catch(MobileNumberNotValidException exception) {
			return (CrudDto) prepareExceptionResponse(exception, new CrudDto());
		}
		
		
	}
	


//	@GetMapping("/find/name")
//	public ResponseEntity<List<CrudModel>> findByName(String name){
//		return new ResponseEntity<List<CrudModel>>(crudRepository.findbyName(name),HttpStatus.OK);
//	}
//	public List<CrudModel> findByName(String name) {
//		return crudService.findByName(name);
//	}
	
	@GetMapping("/findByEmail")
	public CrudModel findByEmail(String email) {
		return crudService.findUsingEmail(email);
	}
	
	@GetMapping("find/mobile")
	public List<CrudModel> findByMobileNumber(String mobileNumber) {
		return crudService.findByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/find/firstName")
	List<CrudModel> findByFirstName(String firstName){
		return crudService.findByFirstName(firstName);
	}
	
//	@PutMapping("/{update}")
//	public List<CrudModel> update(@PathVariable Long id,@RequestBody CrudModel crudModel) {
//		return crudService.updateName(id, crudModel);
//	} 
	
	@GetMapping("/findAll")
	public List<CrudModel> findAll (){
		return crudService.findAll();
	}
	@PutMapping("/updateCrud/{id}")
	public ResponseEntity<CrudModel> updateFields(@PathVariable /* ("id") */ 
			("id") Long id, @RequestBody CrudModel crudModel){
		    Optional<CrudModel> student=crudRepository.findById(id);
		    if(student.isPresent()) {
		    	student.get().setFirstName(crudModel.getFirstName());
		    	student.get().setName(crudModel.getName());
		    	student.get().setEmail(crudModel.getEmail());
		    	student.get().setMobileNumber(crudModel.getMobileNumber());
		    	
		    	return new ResponseEntity<CrudModel>(crudRepository.save(student.get()) ,HttpStatus.OK);
		    }else {
//		    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    	return new ResponseEntity<CrudModel>(HttpStatus.NOT_FOUND);
		    }
	}
	
	@DeleteMapping("/delete")
	public void delete(Long id) {
		crudRepository.deleteById(id);
		
	}
	
	private ResponseDto converToDto(CrudModel crudModel) {
     ResponseDto response=modelMapper.map(crudModel, CrudDto.class);
     prepareResponse(response, "Success", "field has been  created", 200 );
		return response;
	}
}
