/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.view;

import com.siquoia.command.Command;
import com.siquoia.command.DisplayCategoryCommand;
import com.siquoia.command.LoginCommand;
import com.siquoia.command.LogoutCommand;
import com.siquoia.command.QuestionCommand;
import com.siquoia.command.SelectCategoryCommand;
import com.siquoia.command.SelectUnverifiedQuestionCommand;
import com.siquoia.command.TargetCommand;
import com.siquoia.command.VerifyQueCommand;
import com.siquoia.command.ViewSubmitedResultCommand;
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
        commands.put("selectCategoryList", new SelectCategoryCommand("AddQuestion.jsp"));
        commands.put("addQue", new QuestionCommand("SucessPage.jsp"));
        commands.put("selectUnverifiedQue", new SelectUnverifiedQuestionCommand("VerifyQue.jsp"));
        commands.put("verifyQue", new VerifyQueCommand("SucessPage.jsp"));
        commands.put("viewSubmitedResult", new ViewSubmitedResultCommand("viewSubmittedResult.jsp"));
    }
    
    public Command findCommand(String name){
        return commands.get(name);
    }
    
}
