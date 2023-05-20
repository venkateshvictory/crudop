package com.trainee.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.crud.model.BankModel;

@Repository("bankRepository")
public interface BankRepository extends JpaRepository<BankModel, Long>{

	public BankModel findByAccountNumber(String accountNumber);

}
