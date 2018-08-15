package com.goShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goShopping.dbutility.DbConnection;
import com.goShopping.dto.Category;
import com.goShopping.dto.Item;

public class ItemDao {
	public boolean insertItem(Item item) {
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO item VALUES (?, ?, ?, ?, ?)");
	        
	        ps.setInt(1, item.getItemId());
	        ps.setString(2, item.getItemDescription());
	        ps.setString(3, item.getItemOld());
	        ps.setInt(4, item.getItemPrice());
	        ps.setInt(5, item.getItemStatus());
	        
	   
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;	}
public boolean updateItem(Item item) {
	    
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement pst = connection.prepareStatement("UPDATE category SET ItemId=?, itemDescription=?,itemOld=?, itemPrice=?, itemStstus=? WHERE subCategoryId =?, userId=?, moderatorId=?");
	        pst.setInt(1, item.getItemId());
	        pst.setString(2, item.getItemDescription());
	        pst.setString(3, item.getItemOld());
	        pst.setInt(4,  item.getItemPrice());
	        pst.setInt(5, item.getItemStatus());
	       
	        int i = pst.executeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
public boolean deleteItem(int id, Item item) {
    Connection connection = DbConnection.getConnection();
    try {
    	PreparedStatement pst = connection.prepareStatement("DELETE FROM item  WHERE  itemId = ?, itemDescription = ?, itemOld = ?, itemPrice = ?, itemStatus = ?, WHERE subCategoryId = ?, userId = ?, moderatorId = ?" );
    	 pst.setInt(1, item.getItemId());
	     pst.setString(2, item.getItemDescription());
	     pst.setString(3, item.getItemOld());
		 pst.setInt(4,  item.getItemPrice());
         pst.setInt(5, item.getItemStatus());
		 
        long i = pst.executeLargeUpdate();
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false; 
    }

public List<Item> getAllItems(){
	List<Item> list=new ArrayList<>();
        PreparedStatement pst = null;
    	ResultSet rs = null;
    final String SELECT_QUERY = "select * from item ";
    try(Connection con = DbConnection.getConnection();){
    	pst = con.prepareStatement(SELECT_QUERY);
    	rs = pst.executeQuery();
        while(rs.next())
        {
            Item item1=new Item();
            item1.setItemId(rs.getInt(1));
            item1.setItemDescription(rs.getString(2));
    		item1.setItemOld(rs.getString(3));
    		item1.setItemPrice(rs.getInt(4));
    		item1.setItemStatus(rs.getInt(5));
    		list.add(item1);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return list;
}


public static void main(String[] args){
	   
	  ItemDao itemDao = new ItemDao();
	  Item item = new Item();
	  item.setItemId("222,333");
	  item.setCategoryPic("1223");
	  (item).setModeratorId("111");
	    System.out.println(categoryDao.insertCategory(category));{
		
	}
 }
}

	

