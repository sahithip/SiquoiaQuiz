/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.command;

import com.siquoia.exception.CommandException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.impl.UserImpl;
import com.siquoia.model.User;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author PC
 */
public class ProfileCommand extends TargetCommand{
    
    UserImpl userImpl = UserImpl.getInstance();
    
    public ProfileCommand(String target){
        super(target);
    }
    
    public String execute(HttpServletRequest req) throws CommandException{
        long id = Long.parseLong(req.getParameter("id"));
        User user;
        try{
            user = userImpl.profileEdit(id);
        }catch(NotFoundException nfe){
            throw new CommandException("login.jsp", nfe.getMessage(), nfe);
        }
        
        req.setAttribute("user", user);
        return super.execute(req);
    }
}
