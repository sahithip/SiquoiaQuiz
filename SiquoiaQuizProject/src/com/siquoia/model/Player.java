/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.model;

/**
 *
 * @author PC
 */
public class Player extends User{
    private String userType;
    private String firstName;
    private String middleName;
    private String lastName;
    
    public Player(String userName, String password, String email, long userId,
            String userType, String firstName, String middleName, String lastName){
        super(userName, password, email, userId);
        this.userType = userType;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    
    
    
    public Player(String userName, String email, long userId, String userType, String firstName, String middleName, String lastName){
        super(userName, email, userId);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userType = userType;
    }
    
    public String getUserType(){
        return userType;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getMiddleName(){
        return middleName;
    }
    
    public String getLastName(){
        return lastName;
    }
}
