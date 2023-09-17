package com.trainee.crud.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainee.crud.dao.BankRepository;
import com.trainee.crud.model.BankModel;

@Service("bankService")
public class BankService {

	@Resource(name="bankRepository")
	private BankRepository bankRepository;
	
	public BankModel save(BankModel bankModel) {
		return bankRepository.save(bankModel);
	}
	
	public BankModel findByAccount(String accountNumber) {
		return  bankRepository.findByAccountNumber(accountNumber);
	}

	public List<BankModel> findAll() {
		
		return bankRepository.findAll();
	}
	
}
