/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.view;

import java.util.HashMap;

import com.siquoia.command.AjaxCommand;
import com.siquoia.command.Command;
import com.siquoia.command.ConnectCommand;
import com.siquoia.command.CreateUserCommand;
import com.siquoia.command.DisplayCategoryCommand;
import com.siquoia.command.GetResultAjaxCommand;
import com.siquoia.command.LoginCommand;
import com.siquoia.command.LogoutCommand;
import com.siquoia.command.ProfileCommand;
import com.siquoia.command.SaveProfileAjaxCommand;
import com.siquoia.command.TargetCommand;

/**
 *
 * @author PC
 */
public class CommandFactory {
    private static CommandFactory instance;
    private HashMap<String, Command> commands;
    private HashMap<String, AjaxCommand> ajaxcommands;
    
    private CommandFactory(){
        commands = new HashMap<String, Command>();
        ajaxcommands = new HashMap<String, AjaxCommand>();
        setupCommands();
        setupAjaxCommands();
    }
    
    public static CommandFactory getInstance(){
        if(instance == null)
            instance = new CommandFactory();
        return instance;
    }
    
    private void setupCommands(){
    	commands.put(null, new ConnectCommand("login.jsp"));
    	commands.put("signup", new ConnectCommand("signup.jsp"));
    	commands.put("createuser", new CreateUserCommand("home.jsp"));
        commands.put("index", new TargetCommand("login.jsp"));
        commands.put("home", new TargetCommand("home.jsp"));
        commands.put("login", new LoginCommand("home.jsp"));
        commands.put("logout", new LogoutCommand("login.jsp"));
        commands.put("profile", new ProfileCommand("profile.jsp"));
        commands.put("displayCategory", new DisplayCategoryCommand("DisplayCategory.jsp"));
        commands.put("result", new TargetCommand("result.jsp"));
    }
    
    private void setupAjaxCommands(){
        ajaxcommands.put("saveprofile", new SaveProfileAjaxCommand());
        ajaxcommands.put("getresult", new GetResultAjaxCommand());
    }
    
    public Command findCommand(String name){
        return commands.get(name);
    }
    
    public AjaxCommand findAjaxCommand(String name) throws NullPointerException{
        AjaxCommand command = ajaxcommands.get(name);
        if(command == null)
            throw new NullPointerException();
        return command;
    }
    
}
