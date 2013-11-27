/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.view;

import com.siquoia.command.Command;
import com.siquoia.command.DisplayCategoryCommand;
import com.siquoia.command.LoginCommand;
import com.siquoia.command.LogoutCommand;
import com.siquoia.command.TargetCommand;
import com.siquoia.control.DBManager;

import java.util.HashMap;

/**
 *
 * @author PC
 */
public class CommandFactory {
    private static CommandFactory instance;
    private HashMap<String, Command> commands;
    
    private CommandFactory(){
        commands = new HashMap<String, Command>();
        setupCommands();
    }
    
    public static CommandFactory getInstance(){
        if(instance == null)
            instance = new CommandFactory();
        return instance;
    }
    
    private void setupCommands(){
        commands.put("index", new TargetCommand("login.jsp"));
        commands.put("login", new LoginCommand("home.jsp"));
        commands.put("logout", new LogoutCommand("login.jsp"));
        commands.put("displayCategory", new DisplayCategoryCommand("DisplayCategory.jsp"));
    }
    
    public Command findCommand(String name){
        return commands.get(name);
    }
    
}
