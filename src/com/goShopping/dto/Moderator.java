package com.goShopping.dto;

public class Moderator {
     private int moderatorId;
     private String moderatorName;
     private String moderatorPassword;
	public int getModeratorId() {
		return moderatorId;
	}
	public void setModeratorId(int moderatorId) {
		this.moderatorId = moderatorId;
	}
	public String getModeratorName() {
		return moderatorName;
	}
	public void setModeratorName(String moderatorName) {
		this.moderatorName = moderatorName;
	}
	public String getModeratorPassword() {
		return moderatorPassword;
	}
	public void setModeratorPassword(String moderatorPassword) {
		this.moderatorPassword = moderatorPassword;
	}
	@Override
	public String toString() {
		return "Moderator [moderatorId=" + moderatorId + ", moderatorName=" + moderatorName + ", moderatorPassword="
				+ moderatorPassword + "]";
	}
     
     
}
