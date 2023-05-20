package com.trainee.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_STATEMENTS")
public class BankStatements {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="WITHDRAW")
	private Double withdraw;
	
	@Column(name="TRANSFERED_AMOUNT")
	private Double transferedAmount;
	
	@Column(name="DEPOSIT")
	private Double deposit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}

	public Double getTransferedAmount() {
		return transferedAmount;
	}

	public void setTransferedAmount(Double transferedAmount) {
		this.transferedAmount = transferedAmount;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	
	
}
