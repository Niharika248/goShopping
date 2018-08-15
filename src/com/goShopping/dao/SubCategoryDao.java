package com.goShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goShopping.dbutility.DbConnection;
import com.goShopping.dto.Category;
import com.goShopping.dto.SubCategory;

public class SubCategoryDao {
	public boolean insertSubCategory(SubCategory subCategory) {
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO subCategory VALUES ( ?, ?, ?)");
	        
	        ps.setString(1, subCategory.getSubCategoryName());
	        ps.setInt(2, subCategory.getSubCategoryId());
	        ps.setString(3, subCategory.getSubCategoryPic());
	   
	        
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
public boolean updateSubCategory(SubCategory subCategory) {
	    
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement pst = connection.prepareStatement("UPDATE category SET subCategoryId=?, subCategoryName=?, subCategoryPic=? WHERE moderatorId =?");
	        pst.setInt(1, subCategory.getSubCategoryId());
	        pst.setString(2, subCategory.getSubCategoryName());
	        pst.setString(3, subCategory.getSubCategoryPic());
	       
	        int i = pst.executeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	    }
public boolean deleteSubCategory(int id, SubCategory subCategory) {
    Connection connection = DbConnection.getConnection();
    try {
    	PreparedStatement pst = connection.prepareStatement("DELETE FROM category  WHERE  subCategoryId = ?,subCategoryPic = ? WHERE moderatorId = ?" );
    	 pst.setInt(1, subCategory.getSubCategoryId());
	     pst.setString(2, subCategory.getSubCategoryName());
	     pst.setString(3, subCategory.getSubCategoryPic());
		
        
        long i = pst.executeLargeUpdate();
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
public List<SubCategory> getAllSubCategories(){
	List<SubCategory> list=new ArrayList<>();
        PreparedStatement pst = null;
    	ResultSet rs = null;
    final String SELECT_QUERY = "select * from  ";
    try(Connection con = DbConnection.getConnection();){
    	pst = con.prepareStatement(SELECT_QUERY);
    	rs = pst.executeQuery();
        while(rs.next())
        {
            SubCategory subCategory1=new SubCategory();
           subCategory1.setSubCategoryId(rs.getInt(1));
            subCategory1.setSubCategoryName(rs.getString(2));
    		subCategory1.setSubCategoryPic(rs.getString(3));
    		list.add(subCategory1);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return list;
}

public static void main(String[] args){
	   
	  SubCategoryDao subcategoryDao = new SubCategoryDao();
	  SubCategory subcategory = new SubCategory();
	  subcategory.setSubCategoryName("sofa, dinning table, bed, reading tables, dressing tables, decorative showcases, corner tables");
	  subcategory.setSubCategoryPic("145,453,665,727,886,944,992");
	  ( subcategory).setModeratorId("222");
	    System.out.println(subcategoryDao.insertSubCategory(subcategory));{
		
	}
 }
}

