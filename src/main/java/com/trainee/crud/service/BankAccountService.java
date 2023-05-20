package com.trainee.crud.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainee.crud.dao.BankStatementsRepository;

@Service("bankAccountService")
public class BankAccountService {

	@Resource(name="bankStatementRepository")
	private BankStatementsRepository bankStatementRepository;
}
