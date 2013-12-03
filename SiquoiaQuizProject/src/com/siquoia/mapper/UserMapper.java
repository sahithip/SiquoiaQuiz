/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.siquoia.exception.AuthenticationException;
import com.siquoia.exception.ExistsException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.NotPersistedException;
import com.siquoia.model.Player;
import com.siquoia.model.User;

/**
 *
 * @author PC
 */
public class UserMapper {
    
    public User getUser(String userName, Connection conn) throws NotFoundException{
        String SQL = "select * from user where user_name = ?";
        Player player = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
        	System.out.println("conn---"+conn);
            ps = conn.prepareStatement(SQL);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if(rs.next())
                player = new Player(rs.getString(2), rs.getString(3), rs.getString(4), (long)rs.getInt(1), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
            try{
                conn.rollback();
            }catch(SQLException sqle){
                throw new NotFoundException(0L, sqle.getMessage());
            }
        }
        return player;
    }
    
    public User getUser(long userId, Connection conn) throws NotFoundException{
        String SQL = "select * from user where user_id = ?";
        Player player = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(SQL);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            if(rs.next())
                player = new Player(rs.getString(2), rs.getString(3), rs.getString(4), (long)rs.getInt(1), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
        }catch(SQLException ex){
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
            try{
                conn.rollback();
            }catch(SQLException sqle){
                sqle.printStackTrace();
                throw new NotFoundException(userId, sqle.getMessage());
            }
        }
        return player;
    }
    
    public User saveUser(String userName, String password, String email, String firstName, String middleName, String lastName, Connection conn) throws NotPersistedException, ExistsException{
    	//1. Check if user already exists
        String SQL1 = "select * from user where user_name = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = conn.prepareStatement(SQL1);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if(rs.next())
                throw new ExistsException(rs.getInt(1), "User already exists: " + rs.getString(2)); //User already exists, give error
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException sqle){
                throw new NotPersistedException(0L, "Could not connect");
            }
        }
        
        //2. Since user does not already exist, persist new one in database
        String SQL2 = "insert into user values(NULL,'"+userName+"','"+password+"','"+email+"', 'free','"+firstName+"','"+middleName+"','"+lastName+"')";
        
        Statement stmt;
        
        try{
        	stmt = conn.createStatement();
        	stmt.execute(SQL2);
        }catch(SQLException ex){
        	try{
        		conn.rollback();
        		throw new NotPersistedException(0L, "Could not persist");
        	}catch(SQLException sqle){}
        }
        
        //3. Get the id of the inserted user
        String SQL3 = "select LAST_INSERT_ID()";
        ResultSet rs3;
        PreparedStatement ps3;
        long userId = 0L;
        try{
        	ps3 = conn.prepareStatement(SQL3);
        	rs3 = ps3.executeQuery();
        	if(rs3.next())
        		userId = (long)rs3.getInt(1);
        }catch(SQLException ex){
        	try{
        		conn.rollback();
        	}catch(SQLException sqle){
        		throw new ExistsException(0L, "User does not exist!");
        	}
        }
        
        
        return new Player(userId, userName, password, email, "free", firstName, middleName, lastName);
    }
    
    public User saveUser(long id, String userName, String email, String firstName, String middleName, String lastName, Connection conn) throws AuthenticationException, NotPersistedException{
        //1. Check if user is still in database
        String SQL1 = "select * from user where user_id = ?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(SQL1);
            ps.setInt(1, (int)id);
            rs = ps.executeQuery();
            if(!rs.next())
                throw new AuthenticationException("Editing user not authenticated.");
        }catch(SQLException ex){
            try{
                conn.rollback();
                throw new AuthenticationException("Editing user not authenticated.");
            }catch(SQLException sqle){
                throw new AuthenticationException("Editing user not authenticated.");
            }
        }
        
        //2. Perform query on database
        String SQL2 = "update user set user_name = ?, email = ?, first_name = ?, middle_name = ?, last_name = ? where user_id = ?";
        try{
            ps = conn.prepareStatement(SQL2);
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, firstName);
            ps.setString(4, middleName);
            ps.setString(5, lastName);
            ps.setInt(6, (int)id);
            ps.executeUpdate();
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException sqle){
                throw new NotPersistedException(id, "Could not persist profile.");
            }
        }
        
        return new Player(userName, email, id, null, firstName, middleName, lastName);
        
        
    }
}
