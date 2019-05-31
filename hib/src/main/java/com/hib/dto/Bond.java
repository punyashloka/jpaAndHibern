package com.hib.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bond extends ShareDetails {
	

	@Column(name = "interest_percent")
	private BigDecimal interest;
	@Column(name = "maturity_value")
	private BigDecimal maturityVal;
	
	public BigDecimal getInterest() {
		return interest;
	}
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
	public BigDecimal getMaturityVal() {
		return maturityVal;
	}
	public void setMaturityVal(BigDecimal maturityVal) {
		this.maturityVal = maturityVal;
	}
	
	
}
