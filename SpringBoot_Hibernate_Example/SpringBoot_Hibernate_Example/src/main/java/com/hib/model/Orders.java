package com.hib.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3750447391142192478L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	@ApiModelProperty(hidden=true)
	private long orderId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status_code", nullable = false)
	private OrderStatusCode statusCode;

	@Column(name = "order_date", nullable = false)
	private Date orderDate;

	@Column(name = "delivery_date")
	private Date deliveryDate;
	
	private String comment;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderStatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(OrderStatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
