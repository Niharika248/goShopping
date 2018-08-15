package com.goShopping.dao;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.catalina.connector.Connector;

import com.goShopping.dto.User;
import com.goShopping.dbutility.DbConnection;
import com.goShopping.dto.User;


public class UserDao {
	public boolean insertUser(User user) {
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES ( ?, ?, ?,?)");
	        
	        ps.setString(2, user.getUserName());
	        ps.setString(3, user.getUserPassword());
	        ps.setInt(4, user.getUserPhone());
	        ps.setString(5, user.getUserEmailId());
	        
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	public User getUser(int userId,String userName,String userPassword,int userPhone,String userEmailId){
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user=null;
	final String SELECT_QUERY = "select * from user where userName = ? ,userPassword = ? ,userPhone = ? ,userEmailId = ?";
	try(Connection con = DbConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, userName);
		pst.setString(2, userPassword);
		pst.setInt(3, userPhone);
		pst.setString(4, userEmailId);
		
		rs= pst.executeQuery();
		if(rs.next()){
			 user=new User();
			 
			 user.setUserName(rs.getString(1));
			 user.setUserPhone(rs.getInt(2));
			 user.setUserPassword(rs.getString(3));
			 user.setUserEmailId(rs.getString(4));
		System.out.println(user);
		}
		} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
	}
	
	public User getUserByUserEmailId(String userEmailId) {
	    
	    Connection connection = DbConnection.getConnection();
	    User user = new User();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE userEmailId = ?");
	        ps.setString(1, userEmailId);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	
	            user.setUserName( rs.getString("userName") );
	            user.setUserPassword( rs.getString("userPassword") );
	            user.setUserPhone( rs.getInt("userPhone") );
	            return user;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return user;
	}
	
	
	
	public List<User> getAllUsers(){
		List<User> list=new ArrayList<>();
	        PreparedStatement pst = null;
	    	ResultSet rs = null;
	    final String SELECT_QUERY = "select * from user ";
	    try(Connection con = DbConnection.getConnection();){
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	rs = pst.executeQuery();
	        while(rs.next())
	        {
	            User user1=new User();
	    	    user1.setUserName(rs.getString(1));
	    		user1.setUserPassword(rs.getString(2));
	    		user1.setUserPhone(rs.getInt(3));
	    		user1.setUserEmailId(rs.getString(5));
	    		list.add(user1);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return list;
	}
	
	public boolean updateUser(User user) {
	    
	    Connection connection = DbConnection.getConnection();
	    try {
	        PreparedStatement pst = connection.prepareStatement("UPDATE user SET userName=?, userPassword=?, userPhone=? WHERE userEmialId=?");
	        pst.setString(1, user.getUserName());
	        pst.setString(2, user.getUserPassword());
	        pst.setInt(3, user.getUserPhone());
	        pst.setString(4, user.getUserEmailId());
	        int i = pst.executeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	public boolean deleteUser(int id, User user) {
	    Connection connection = DbConnection.getConnection();
	    try {
	    	PreparedStatement pst = connection.prepareStatement("DELETE FROM user WHERE id=" + id );
	    	
			
	        pst.setString(1, user.getUserEmailId());
	        long i = pst.executeLargeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
}

	
	
       
	
