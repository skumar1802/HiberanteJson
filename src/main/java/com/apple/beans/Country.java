 package com.apple.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country{
	
	@Id
	@Column(name="Country_ID",unique=true, nullable=false)
	int id;
	
	@Column(name="Country_name",nullable=false)
	String countryName;	
	
	public Country() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}	
	
}