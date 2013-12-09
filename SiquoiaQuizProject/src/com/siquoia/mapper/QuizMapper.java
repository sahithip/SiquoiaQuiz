/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.siquoia.control.DBManager;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.RollBackException;
import com.siquoia.model.Category;
import com.siquoia.model.Quiz;
import com.siquoia.model.QuizResult;
import com.siquoia.model.User;

/**
 *
 * @author PC
 */
public class QuizMapper implements Mapper{
	
    public QuizResult getResult(long quizId, Connection conn) throws NotFoundException, RollBackException{
    	
    	DBManager manager = DBManager.getInstance();
    	//1. Get the Quiz contents
    	String SQL1 = "select * from quiz where quiz_id = ?";
    	Quiz quiz;
    	User user;
    	
    	PreparedStatement ps;
    	ResultSet rs;
    	
    	try{
    		ps = conn.prepareStatement(SQL1);
    		ps.setInt(1, (int)quizId);
    		rs = ps.executeQuery();
    		
    		if(rs.next()){
    			user = manager.getUser(rs.getInt(2));
    			quiz = new Quiz(quizId, manager.getCategory((long)rs.getInt(3)), user, rs.getInt(4));
    		}else
    			throw new NotFoundException(quizId, "Could not find quiz");
    	}catch(SQLException ex){
    		try{
    			conn.rollback();
    			throw new NotFoundException(quizId, "Could not find quiz");
    			}catch(SQLException sqle){
    				 throw new RollBackException(this);
    			}
    	}
    	
    	//2. Return a QuizResult object with necessary data
    	return new QuizResult(quiz, manager.getAchievement(user.getUserId()));
    }
    
    public ArrayList<Category> getCategories(Connection conn) throws NotFoundException, RollBackException{
    	String SQL1 = "select * from category";
    	
    	PreparedStatement ps;
    	ResultSet rs;
    	ArrayList<Category> categories = new ArrayList<Category>();
    	
    	try{
    		ps = conn.prepareStatement(SQL1);
    		rs = ps.executeQuery();
    		
    		while(rs.next()){
    			if(rs.getInt(2) == 0)			//Parent ID = null, therefore we must look for subcategories for this category and add them
    				categories.add(new Category(rs.getInt(1), rs.getString(3), DBManager.getInstance().getSubCategories(rs.getInt(1))));
				else
    				categories.add(new Category(rs.getInt(1), rs.getString(3), null));
    		}
    		
    	}catch(SQLException ex){
    		try{
    			conn.rollback();
    			throw new NotFoundException(0L, "Could not find categories");
    		}catch(SQLException sqle){
    			throw new RollBackException(this);
    		}
    	}
    	return categories;
    }
    
    public Category getCategory(long categoryId, Connection conn) throws NotFoundException, RollBackException{
    	
    	String SQL1 = "select * from category where category_id = ?";
    	
    	PreparedStatement ps;
    	ResultSet rs;
    	Category category = null;
    	
    	try{
    		ps = conn.prepareStatement(SQL1);
    		ps.setInt(1, (int)categoryId);
    		rs = ps.executeQuery();
    		
    		if(rs.next()){
    			category = new Category(categoryId, rs.getString(3), null);
    			if(rs.getInt(2) == 0){	//If parent ID is NULL, which means it's a super category and we need to get the subcategory
    				category.setSubCategories(DBManager.getInstance().getSubCategories(categoryId));
    			}
    		}
    	}catch(SQLException ex){
    		try{
    			conn.rollback();
    			throw new NotFoundException(categoryId, "Could not find category");
    		}catch(SQLException sqle){
    			throw new RollBackException(this);
    		}
    	}
    	
    	return category;
    }
    
    public ArrayList<Category> getSubCategories(long parentId, Connection conn) throws NotFoundException, RollBackException{
    	String SQL1 = "select * from category where parent_id = ?";
    	
    	PreparedStatement ps;
    	ResultSet rs;
    	
    	ArrayList<Category> categories = new ArrayList<Category>();
    	try{
    		ps = conn.prepareStatement(SQL1);
    		ps.setInt(1, (int)parentId);
    		
    		rs = ps.executeQuery();
    		
    		while(rs.next()){
    			categories.add(new Category((long)rs.getInt(1), rs.getString(3), null));
    		}
    	}catch(SQLException ex){
    		try{
    			conn.rollback();
    			throw new NotFoundException(parentId, "Could not find subcategories");
    		}catch(SQLException sqle){
    			throw new RollBackException(this);
    		}
    	}
    	
    	return categories;
    	
    }
    
    public String toString(){
    	return "QuizMapper";
    }
    
    
}
