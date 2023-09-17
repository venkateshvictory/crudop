package com.trainee.crud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.crud.dao.BankStatementsRepository;
import com.trainee.crud.model.BankModel;
import com.trainee.crud.service.BankService;

@RestController
@RequestMapping("/api/bank")
public class BankController {

	@Resource(name="bankService")
	private BankService bankService;
	
	@Resource(name="bankStatementRepository")
	private BankStatementsRepository bankStatementRepository;
	
	@PostMapping("/create")
	private BankModel save(@RequestBody BankModel bankModel) {
	return	bankService.save(bankModel);
	}
	
	@PostMapping("/deposit")
	private BankModel depositAmount(@RequestBody BankModel model) {
	       
		BankModel model1 = new BankModel();
		
		return bankService.save(model);
		
	}
	
	@GetMapping("/findByAccountNumber/{id}")
	public BankModel findByAccount(@PathVariable("id") String accountNumber) {
		return bankService.findByAccount(accountNumber);
	}
	@GetMapping("/list")
	public List<BankModel> list() {
		return bankService.findAll();
	}
	
}
