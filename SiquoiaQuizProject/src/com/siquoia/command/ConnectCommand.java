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
public class ConnectCommand implements Command{

    private String target;
    public ConnectCommand(String target){
        this.target = target;
    }
    
    @Override
    public String execute(HttpServletRequest req) throws CommandException {
        return target;
    }
    
}
