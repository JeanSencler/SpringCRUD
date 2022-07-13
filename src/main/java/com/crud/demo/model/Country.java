package com.crud.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY_ID")
	private long countryId;
	@Column(name = "COUNTRY_NAME")
	private String name;
	@Column(name = "INDEPENDENT")
	private String independent;
	
	public Country() {
		
	}
	
	public Country(long countryId, String countryName, String independent) {
		this.countryId = countryId;
		this.name = countryName;
		this.independent = independent;
	}
	
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String countryName) {
		this.name = countryName;
	}
	public String getIndependent() {
		return independent;
	}
	public void setIndependent(String independent) {
		this.independent = independent;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + name + ", state=" + independent + "]";
	}
	
}
