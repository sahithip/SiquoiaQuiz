/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.impl;

import java.sql.SQLException;

import com.siquoia.control.DBManager;
import com.siquoia.exception.AuthenticationException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.mapper.UserMapper;
import com.siquoia.model.User;

/**
 *
 * @author PC
 */
public class LoginImpl {

    private UserMapper          uMapper = new UserMapper();
    public User login(String userName, String password) throws AuthenticationException, SQLException{
        User user = verifyUser(userName, password);
        System.out.println("---"+user);
        //if(user.getPassword().equals(password)){
            return user;
        //}
        //else{
          //  throw new AuthenticationException("/login.jsp");
        //}
    }
    public User verifyUser(String userName, String password) throws AuthenticationException, SQLException{
        User user;
       // try{
           // user = uMapper.verifyUser(userName, password);
          //  System.out.println(user);
        //}catch(NotFoundException nfe){
       //     throw new AuthenticationException("User not authenticated");
      //  }
        
        return null;
    }
}