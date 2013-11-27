/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.impl;

import com.siquoia.control.DBManager;
import com.siquoia.exception.AuthenticationException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.NotPersistedException;
import com.siquoia.model.User;

/**
 *
 * @author PC
 */
public class UserImpl {
    DBManager manager = DBManager.getInstance();
    
    private static UserImpl instance;
    
    public static UserImpl getInstance(){
        if(instance == null)
            instance = new UserImpl();
        return instance;
    }
    
    public User login(String userName, String password) throws AuthenticationException{
        User user = manager.getUser(userName, password);
        if(user.getPassword().equals(password)){
            return user;
        }
        else{
            throw new AuthenticationException("Oops, Wrong login. Try again.");
        }
    }
    
    public User profileEdit(long id) throws NotFoundException{
        return manager.getUser(id);
    }
    
    public User saveProfile(long id, String userName, String email, String firstName, String middleName, String lastName) throws AuthenticationException, NotPersistedException{
        return manager.saveUser(id, userName, email, firstName, middleName, lastName);
    }
}