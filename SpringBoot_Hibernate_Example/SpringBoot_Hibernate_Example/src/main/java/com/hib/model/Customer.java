package com.hib.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hib.enums.Gender;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -5628726569856729937L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	@ApiModelProperty(hidden=true)
	private Long customerId;
	@Column(name = "org_or_person")
	private String orgOrPerson;
	@Column(name = "first_name", nullable=false)
	private String firstName;
	@Column(name = "last_name", nullable=false)
	private String lastName;
	@Column(name = "middle_name")
	private String middleName;
	@Basic//(optional=false) makes non null column (optional=true) by default
	@Convert(converter = GenderConverter.class)// convert db value to attribute and vice versa
	public Gender gender;

	@Column(name = "email_address", nullable=false)
	private String emailAddress;
	@Column(name = "user_name", nullable=false)
	private String userName;
	@Column(name = "password", nullable=false)
	private String password;
	@Column(name = "phone_number", nullable=false)
	private Long phoneNumber;
	private String address1;
	private String address2;
	private String city;
	private String country;
	@Column(name = "zip", nullable=false)
	private String zipCode;

	public Customer() {
		super();
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getOrgOrPerson() {
		return orgOrPerson;
	}

	public void setOrgOrPerson(String orgOrPerson) {
		this.orgOrPerson = orgOrPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
