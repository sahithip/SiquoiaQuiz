/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.model;

/**
 *
 * @author PC
 */
public abstract class User {
    private Achievement achievement;
    private String      userName;
    private String      password;
    private String      email;
    private long        userId;
    
    public User(String userName, String password, String email, long userId){
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
    
    public User(String userName, String password, String email, long userId, Achievement achievement){
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.achievement = achievement;
    }
    
    public User(String userName, String email, long userId){
        this.userName = userName;
        this.email = email;
        this.userId = userId;
    }
    
    public long getUserId(){
        return userId;
    }
    
    public Achievement getAchievement(){
        return achievement;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getEmail(){
    	return email;
    }
}
