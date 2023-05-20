package com.trainee.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
public class BankModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name="ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	@Column(name="AVAILABEL_BALANCE")
	private Double avalilableBalance;
	
//	@Column(name="AMOUNT_ADDED")
//	private Double amount;

	private Double withdraw;
	private Double credited;
	private Double debited;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getAvalilableBalance() {
		return avalilableBalance;
	}

	public void setAvalilableBalance(Double avalilableBalance) {
		this.avalilableBalance = avalilableBalance;
	}

	

	

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}

	public Double getCredited() {
		return credited;
	}

	public void setCredited(Double credited) {
		this.credited = credited;
	}

	public Double getDebited() {
		return debited;
	}

	public void setDebited(Double debited) {
		this.debited = debited;
	}

	
	
	
	
	
    
}
