package com.goShopping.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goShopping.dbutility.DbConnection;
import com.goShopping.dto.Address;
import com.goShopping.dto.Item;

public class addressDao {
	public boolean insertAddress(Address address) {
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO item VALUES (?, ?, ?, ?, ?)");
	        
	        ps.setString(1, address.getCity());
	        ps.setString(2, address.getStreet());
	        ps.setInt(3, address.getPinCode());
	        ps.setString(4, address.getState());
	        ps.setString(5, address.getCountry());
	        
	   
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false; }
	
public boolean updateAddress(Address address) {
	    
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement pst = connection.prepareStatement("UPDATE address SET city=?, street=?, pinCode=?, state=?, country=? WHERE userId=?");
	        pst.setString(1, address.getCity());
	        pst.setString(2, address.getStreet());
	        pst.setInt(3, address.getPinCode());
	        pst.setString(4,  address.getState());
	        pst.setString(5, address.getCountry());
	       
	        int i = pst.executeUpdate();
	        if(i == 1) {
	    	    return true;
	    	      }
	    	    } catch (SQLException ex) {
	    	        ex.printStackTrace();
	    	    }
	    	    return false;
}
	        		public boolean deleteAddress(int id, Address address) {
	            Connection connection = DbConnection.getConnection();
	            try {
	            	PreparedStatement pst = connection.prepareStatement("DELETE FROM address  WHERE city=?, street=?, pinCode=?, state=?, country=? , WHERE userId=?" );
	            	 pst.setString(1, address.getCity());
	        	     pst.setString(2, address.getStreet());
	        	     pst.setInt(3, address.getPinCode());
	        		 pst.setString(4,  address.getState());
	                 pst.setString(5, address.getCountry());
	        		 
	                long i = pst.executeLargeUpdate();
	              if(i == 1) {
	            return true;
	              }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            return false; 
	            }

	        public List<Address> getAllAddress(){
	        	List<Address> list=new ArrayList<>();
	                PreparedStatement pst = null;
	            	ResultSet rs = null;
	            final String SELECT_QUERY = "select * from address";
	            try(Connection con = DbConnection.getConnection();){
	            	pst = con.prepareStatement(SELECT_QUERY);
	            	rs = pst.executeQuery();
	                while(rs.next())
	                {
	                    Address address1=new Address();
	                    address1.setCity(rs.getString(1));
	                    address1.setStreet(rs.getString(2));
	            		address1.setPinCode(rs.getInt(3));
	            		address1.setState(rs.getString(4));
	            		address1.setCountry(rs.getString(5));
	            		list.add(address1);
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            return list;
	        }
 }



