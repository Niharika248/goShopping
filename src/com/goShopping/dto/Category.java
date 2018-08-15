package com.goShopping.dto;

public class Category {
    public interface insert {

	}
	private int categoryId;
    private String categoryName;
    private String categoryPic;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryPic() {
		return categoryPic;
	}
	public void setCategoryPic(String categoryPic) {
		this.categoryPic = categoryPic;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryPic=" + categoryPic
				+ ", getCategoryId()=" + getCategoryId() + ", getCategoryName()=" + getCategoryName()
				+ ", getCategoryPic()=" + getCategoryPic() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public void setModeratorId(String string) {
		
		
	}
    
    
}
