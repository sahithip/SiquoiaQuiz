/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.control;

import java.sql.Connection;
import java.util.ArrayList;

import com.siquoia.dbconnection.DBConnection;
import com.siquoia.exception.AuthenticationException;
import com.siquoia.exception.ExistsException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.NotPersistedException;
import com.siquoia.exception.RollBackException;
import com.siquoia.mapper.LeaderboardMapper;
import com.siquoia.mapper.QuizMapper;
import com.siquoia.mapper.UserMapper;
import com.siquoia.model.Achievement;
import com.siquoia.model.Category;
import com.siquoia.model.QuizResult;
import com.siquoia.model.User;

/**
 *
 * @author PC
 */
public class DBManager {
    private static DBManager    instance;
    private Connection          conn;
    private DBConnection        dbConnection;
    private UserMapper          uMapper;
    private QuizMapper          qMapper;
    private LeaderboardMapper   lMapper;
    
    private DBManager(){
        dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
        uMapper = new UserMapper();
        qMapper = new QuizMapper();
        lMapper = new LeaderboardMapper();
    }
    
    public static DBManager getInstance(){
        if(instance == null)
            instance = new DBManager();
        return instance;
    }
    
    public User getUser(String userName, String password) throws AuthenticationException{
        User user;
        try{
            user = uMapper.getUser(userName, conn);
        }catch(NotFoundException nfe){
            throw new AuthenticationException("User not authenticated");
        }
        
        return user;
    }
    
    public QuizResult getResult(long quizId) throws NotFoundException, RollBackException{
    	return qMapper.getResult(quizId, conn);
    }
    
    public Achievement getAchievement(long userId) throws NotFoundException, RollBackException{
    	return uMapper.getAchievement(userId, conn);
    }
    
    public Category getCategory(long categoryId) throws NotFoundException, RollBackException{
    	return qMapper.getCategory(categoryId, conn);
    }
    
    public ArrayList<Category> getSubCategories(long parentId) throws NotFoundException, RollBackException{
    	return qMapper.getSubCategories(parentId, conn);
    }
    
    public User saveUser(String userName, String password, String email, String firstName, String middleName, String lastName) throws NotPersistedException, ExistsException, RollBackException{
        return uMapper.saveUser(userName, password, email, firstName, middleName, lastName, conn);
    }
    
    public User getUser(long id) throws NotFoundException{
        return uMapper.getUser(id, conn);
    }
    
    public User saveUser(long id, String userName, String email, String firstName, String middleName, String lastName) throws AuthenticationException, NotPersistedException, RollBackException{
        return uMapper.saveUser(id, userName, email, firstName, middleName, lastName, conn);
    }
    
    public void closeConnection(){
        dbConnection.closeConnection(conn);
    }
}
