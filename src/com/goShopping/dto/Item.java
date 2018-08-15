package com.goShopping.dto;

public class Item {
   private int itemId;
   private int userId;
   private String itemDescription;
   private String itemOld;
   private int itemPrice;
   private int itemStatus;
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getItemDescription() {
	return itemDescription;
}
public void setItemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
}
public String getItemOld() {
	return itemOld;
}
public void setItemOld(String itemOld) {
	this.itemOld = itemOld;
}
public int getItemPrice() {
	return itemPrice;
}
public void setItemPrice(int itemPrice) {
	this.itemPrice = itemPrice;
}
public int getItemStatus() {
	return itemStatus;
}
public void setItemStatus(int itemStatus) {
	this.itemStatus = itemStatus;
}
@Override
public String toString() {
	return "Item [itemId=" + itemId + ", userId=" + userId + ", itemDescription=" + itemDescription + ", itemOld="
			+ itemOld + ", itemPrice=" + itemPrice + ", itemStatus=" + itemStatus + ", getItemId()=" + getItemId()
			+ ", getUserId()=" + getUserId() + ", getItemDescription()=" + getItemDescription() + ", getItemOld()="
			+ getItemOld() + ", getItemPrice()=" + getItemPrice() + ", getItemStatus()=" + getItemStatus()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
   
}
