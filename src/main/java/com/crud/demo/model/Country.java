package com.crud.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long countryId;
	private String countryName;
	private char state;
	
	public Country() {
		
	}
	
	public Country(long countryId, String countryName, char state) {
		this.countryId = countryId;
		this.countryName = countryName;
		this.state = state;
	}
	
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", state=" + state + "]";
	}
	
}
