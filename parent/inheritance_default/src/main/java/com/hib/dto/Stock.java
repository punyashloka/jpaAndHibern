package com.hib.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Stock extends ShareDetails {
	
	private BigDecimal price;
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
}
