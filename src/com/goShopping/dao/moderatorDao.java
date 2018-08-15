package com.goShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goShopping.dbutility.DbConnection;
import com.goShopping.dto.Moderator;

public class moderatorDao {
	public boolean insertModerator(Moderator moderator) {
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO item VALUES (?, ?, ?)");
	        
	        ps.setInt(1, moderator.getModeratorId());
	        ps.setString(2, moderator.getModeratorName());
	        ps.setString(3, moderator.getModeratorPassword());
	        
	   
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;	
	} 
	public boolean updateModerator(Moderator moderator) {
    
    Connection connection = DbConnection.getConnection();
    try {
        PreparedStatement pst = connection.prepareStatement("UPDATE moderator SET ModeratorId=?, ModeratorName=? =?, ModeratorPassword=?");
        pst.setInt(1, moderator.getModeratorId());
        pst.setString(2, moderator.getModeratorName());
        pst.setString(3, moderator.getModeratorPassword());
       
       
        int i = pst.executeUpdate();
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
	}
	public boolean deleteModerator(int id, Moderator moderator) {
	    Connection connection = DbConnection.getConnection();
	    try {
	    	PreparedStatement pst = connection.prepareStatement("DELETE FROM item  WHERE  moderatorId=?, ModeratorName=?, ModeratorPassword=?" );
	    	 pst.setInt(1, moderator.getModeratorId());
		     pst.setString(2, moderator.getModeratorName());
		     pst.setString(3, moderator.getModeratorName());
		     
			 
	        long i = pst.executeLargeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false; 
	    }
	public List<Moderator> getAllModerator(){
		List<Moderator> list=new ArrayList<>();
	        PreparedStatement pst = null;
	    	ResultSet rs = null;
	    final String SELECT_QUERY = "select * from item moderator";
	    try(Connection con = DbConnection.getConnection();){
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	rs = pst.executeQuery();
	        while(rs.next())
	        {
	            Moderator moderator1=new Moderator();
	            moderator1.setModeratorId(rs.getInt(1));
	            moderator1.setModeratorName(rs.getString(2));
	    		moderator1.setModeratorPassword(rs.getString(3));
	    		list.add(moderator1);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return list;
	}
	}
	
