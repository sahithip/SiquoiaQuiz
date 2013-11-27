/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.command;

import com.siquoia.exception.AuthenticationException;
import com.siquoia.exception.CommandException;
import com.siquoia.exception.NotPersistedException;
import com.siquoia.impl.UserImpl;
import com.siquoia.model.User;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;

/**
 *
 * @author PC
 */
public class SaveProfileAjaxCommand extends AjaxCommand{
    
    private UserImpl userImpl = UserImpl.getInstance();
    private long userId;
    private String userName;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    
    public String execute(HttpServletRequest request, String data) throws CommandException{
        userId = Long.parseLong(request.getParameter("userId"));
        userName = request.getParameter("userName");
        email = request.getParameter("email");
        firstName = request.getParameter("firstName");
        middleName = request.getParameter("middleName");
        lastName = request.getParameter("lastName");
        User user = null;
        Gson json = new Gson();
        try{
            System.err.println("DOING IT");
            user = userImpl.saveProfile(userId, userName, email, firstName, middleName, lastName);
            System.err.println("I DID IT");
        }catch(AuthenticationException ae){
            throw new CommandException("login.jsp", ae.getMessage(), ae);
        }catch(NotPersistedException npe){
            throw new CommandException("login.jsp", npe.getMessage(), npe);
        }
        return super.execute(request, json.toJson(user));
    }
    
    private String createJSON(){
//        String data = "{"
//                +"\"userName:\""  +   "\""+userName+"\",\n"
//                +"\"email:\""     +   "\""+email+"\",\n"
//                +"\"firstName:\"" +   "\""+firstName+"\",\n"
//                +"\"middleName:\""+   "\""+middleName+"\",\n"
//                +"\"lastName:\""  +   "\""+lastName+"\",\n"
//                +"}";
        return null;
    }
}
