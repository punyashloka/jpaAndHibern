package com.hib.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)//default dtype
@DiscriminatorValue(value = "sd")
public class ShareDetails {
	@Id
	@GeneratedValue
	private Long shareDetailsId;
    @Column(name = "name")
	private String name;
    @Column(name = "issuer")
	private String issuer;
    @Column(name = "date")
	private Date date;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ShareDetails [name=" + name + ", issuer=" + issuer + ", date=" + date + "]";
	}

	public Long getShareDetailsId() {
		return shareDetailsId;
	}

	public void setShareDetailsId(Long shareDetailsId) {
		this.shareDetailsId = shareDetailsId;
	}

}