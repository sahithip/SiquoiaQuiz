/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.control;

import com.siquoia.dbconnection.DBConnection;
import com.siquoia.exception.AuthenticationException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.NotPersistedException;
import com.siquoia.mapper.LeaderboardMapper;
import com.siquoia.mapper.QuizMapper;
import com.siquoia.mapper.UserMapper;
import com.siquoia.model.User;
import java.sql.Connection;

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
    
    public User getUser(long id) throws NotFoundException{
        return uMapper.getUser(id, conn);
    }
    
    public User saveUser(long id, String userName, String email, String firstName, String middleName, String lastName) throws AuthenticationException, NotPersistedException{
        return uMapper.saveUser(id, userName, email, firstName, middleName, lastName, conn);
    }
    
    public void closeConnection(){
        dbConnection.closeConnection(conn);
    }
}
