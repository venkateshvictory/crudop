package com.trainee.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.crud.model.BankStatements;
@Repository("bankStatementRepository")
public interface BankStatementsRepository extends JpaRepository<BankStatements, Long>{

}
