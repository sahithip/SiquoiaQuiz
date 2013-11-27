/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.command;

import com.siquoia.exception.CommandException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author PC
 */
public class AjaxCommand {
    
    public String execute(HttpServletRequest request, String data) throws CommandException{
        if(request.getSession().getAttribute("loggedIn") == null){
            throw new CommandException("login.jsp", "Session Expired. Please log in again.", new CommandException());
        }
        return data;
    }
}
