package com.hib.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = -8801832667968337153L;

	@Id
	@GeneratedValue( strategy =GenerationType.IDENTITY)
	@Column(name = "product_id")
	@ApiModelProperty(hidden=true)
	private Long productId;
	//@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "type_code")
	//@PrimaryKeyJoinColumn
	private Long typeCode;
	@Column(name = "product_name")
	private String productName;
	
	private String description;
	private Double price;
	@Column(name = "other_details")
	private String otherDetails;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(Long typeCode) {
		this.typeCode = typeCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	
	
}
