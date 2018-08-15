package com.goShopping.dto;

public class pices {
    private int itemId;
    private String pic;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "pices [itemId=" + itemId + ", pic=" + pic + "]";
	}
    
}
