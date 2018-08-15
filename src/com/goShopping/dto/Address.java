package com.goShopping.dto;

public class Address {
	
    private int userId;
    private String city;
    private String street;
    private int pinCode;
    private String state;
    private String country;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [userId=" + userId + ", city=" + city + ", street=" + street + ", pinCode=" + pinCode
				+ ", state=" + state + ", country=" + country + ", getUserId()=" + getUserId() + ", getCity()="
				+ getCity() + ", getStreet()=" + getStreet() + ", getPinCode()=" + getPinCode() + ", getState()="
				+ getState() + ", getCountry()=" + getCountry() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}
