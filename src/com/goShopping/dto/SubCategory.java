package com.goShopping.dto;

public class SubCategory {
    private int subCategoryId;
    private String subCategoryName;
    private String subCategoryPic;
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getSubCategoryPic() {
		return subCategoryPic;
	}
	public void setSubCategoryPic(String subCategoryPic) {
		this.subCategoryPic = subCategoryPic;
	}
	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName
				+ ", subCategoryPic=" + subCategoryPic + ", getSubCategoryId()=" + getSubCategoryId()
				+ ", getSubCategoryName()=" + getSubCategoryName() + ", getSubCategoryPic()=" + getSubCategoryPic()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
}
