package com.goShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goShopping.dbutility.DbConnection;
import com.goShopping.dto.Item;
import com.goShopping.dto.pices;

public class picesDao {
	public boolean insertItem(pices pices) {
	    Connection connection = DbConnection.getConnection();
	    try {
	        ps.setString(1, pices.getPic());
	        
	   
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;	
	}
	
public boolean updatePices(pices pices) {
	    
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement pst = connection.prepareStatement("UPDATE category SET pic=?, WHERE itemId=?");
	        pst.setString(1, pices.getPic());
	       
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

public List<pices> getAllpices(){
	List<pices> list=new ArrayList<>();
        PreparedStatement pst = null;
    	ResultSet rs = null;
    final String SELECT_QUERY = "select * from pices ";
    try(Connection con = DbConnection.getConnection();){
    	pst = con.prepareStatement(SELECT_QUERY);
    	rs = pst.executeQuery();
        while(rs.next())
        {
            pices pices1=new pices();
            pices1.setPic(rs.getString(1));
    		list.add(pices1);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return list;
}
}

