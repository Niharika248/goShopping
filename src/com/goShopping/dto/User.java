package com.goShopping.dto;

public class User {
    
    private String userName;
    private int userPhone;
    private String userEmailId;
    private String userPassword;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [ userName=" + userName + ", userPhone=" + userPhone + ", userEmailId="
				+ userEmailId + ", userPassword=" + userPassword + "]";
	}
    
}
