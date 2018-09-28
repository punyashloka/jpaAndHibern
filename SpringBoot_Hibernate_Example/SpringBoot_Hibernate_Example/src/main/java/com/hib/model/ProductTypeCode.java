package com.hib.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "product_type_code")
public class ProductTypeCode implements Serializable {
	private static final long serialVersionUID = 3964580393640929367L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_type_id")
	
	private Long productTypeCode;
	@ApiModelProperty(hidden=true)
	private String description;
	@Column(name = "sort_order")
	@ApiModelProperty(hidden=true)
	private Integer sortOrder;
	@ApiModelProperty(hidden=true)
	private Boolean isActive;

	public Long getProductTypeCode() {
		return productTypeCode;
	}

	public void setProductTypeCode(Long productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
