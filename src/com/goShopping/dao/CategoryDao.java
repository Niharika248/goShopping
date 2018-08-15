package com.goShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goShopping.dbutility.DbConnection;
import com.goShopping.dto.Category;
import com.goShopping.dto.Moderator;
import com.goShopping.dto.SubCategory;
import com.goShopping.dto.User;
public class CategoryDao extends Moderator {
	private static Object categoryId;



	public boolean insertCategory(Category category) {
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO category VALUES ( ?, ?)");
	        
	        ps.setString(1, category.getCategoryName());
	       
	        ps.setString(3, category.getCategoryPic());
	   
	        
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
public boolean updateCategory(Category category) {
	    
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement pst = connection.prepareStatement("UPDATE category SET CategoryId=?, categoryName=?, categoryPic=? WHERE moderatorId =?");
	        pst.setInt(1, category.getCategoryId());
	        pst.setString(2, category.getCategoryName());
	        pst.setString(3, category.getCategoryPic());
	       
	        int i = pst.executeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
public boolean deleteCategory(int id, Category category) {
    Connection connection = DbConnection.getConnection();
    try {
    	PreparedStatement pst = connection.prepareStatement("DELETE FROM category  WHERE  categoryId = ?,categoryPic = ? WHERE moderatorId = ?" );
    	 pst.setInt(1, category.getCategoryId());
	     pst.setString(2, category.getCategoryName());
	     pst.setString(3, category.getCategoryPic());
		
        
        long i = pst.executeLargeUpdate();
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}                                                                                                                      
public List<Category> getAllCategories(){
	List<Category> list=new ArrayList<>();
        PreparedStatement pst = null;
    	ResultSet rs = null;
    final String SELECT_QUERY = "select * from category ";
    try(Connection con = DbConnection.getConnection();){
    	pst = con.prepareStatement(SELECT_QUERY);
    	rs = pst.executeQuery();
        while(rs.next())
        {
            Category category1=new Category();
            category1.setCategoryId(rs.getInt(1));
            category1.setCategoryName(rs.getString(2));
    		category1.setCategoryPic(rs.getString(3));
    		list.add(category1);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return list;
}

   public static void main(String[] args){

   
	  CategoryDao categoryDao = new CategoryDao();
	  Category category = new Category();
	  category.setCategoryName("furniture");
	  category.setCategoryPic("1223");
	   (category).setModeratorId("111");
	    System.out.println(categoryDao.insertCategory(category));{
		
	}
   }
}

	























