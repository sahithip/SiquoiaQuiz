/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.view;

import com.siquoia.command.Command;
import com.siquoia.command.TargetCommand;
import com.siquoia.exception.CommandException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "SiquoiaFrontController", urlPatterns = {"/SiquoiaFrontController"})
public class SiquoiaFrontController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String commandKey = req.getParameter("command");
        Command command = CommandFactory.getInstance().findCommand(commandKey);
        String target = null;
        try {
        	
            target = command.execute(req);
            System.out.println("---test"+target);
        } catch (CommandException ce) {
            req.setAttribute("cause", ce.getCause());
            req.setAttribute("message", ce.getMessage());
            req.setAttribute("stackTrace", ce.getStackTrace());
            RequestDispatcher dispatcher = req.getRequestDispatcher(ce.getErrorTarget());
            dispatcher.forward(req, res);
        }

        req.getRequestDispatcher(target).forward(req, res);
    }
}
