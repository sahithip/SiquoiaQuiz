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
public class LogoutCommand extends ConnectCommand{
    
    public LogoutCommand(String target){
        super(target);
    }
    
    public String execute(HttpServletRequest request) throws CommandException{
        request.getSession().removeAttribute("loggedIn");
        return super.execute(request);
    }
    
}
