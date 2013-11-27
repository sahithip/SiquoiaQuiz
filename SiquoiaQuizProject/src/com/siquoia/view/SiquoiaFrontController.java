package com.siquoia.view;

import com.siquoia.command.AjaxCommand;
import com.siquoia.command.Command;
import com.siquoia.exception.CommandException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        res.setContentType("application/json; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String commandKey = req.getParameter("command");
        Command command = CommandFactory.getInstance().findCommand(commandKey);
        if(command == null){
            ajaxCall(req, res, commandKey);
        }
        else{
            String target = null;
            try {
                target = command.execute(req);
            } catch (CommandException ce) {
                req.getSession().removeAttribute("loggedIn");
                req.setAttribute("cause", ce.getCause());
                req.setAttribute("message", ce.getMessage());
                req.setAttribute("stackTrace", ce.getStackTrace());
                RequestDispatcher dispatcher = req.getRequestDispatcher(ce.getErrorTarget());
                dispatcher.forward(req, res);
            }catch(NullPointerException npe){
                req.getSession().removeAttribute("loggedIn");
                req.setAttribute("message", "No command found");
            }
            req.getRequestDispatcher(target).forward(req, res);
        }
    }
    
    private void ajaxCall(HttpServletRequest req, HttpServletResponse res, String commandKey) throws ServletException, IOException{
            
            PrintWriter out = res.getWriter();
            AjaxCommand command = CommandFactory.getInstance().findAjaxCommand(commandKey);

            try{
                out.println(command.execute(req, ""));
                System.out.println(command.execute(req, ""));
            } catch (CommandException ex) {
                req.getSession().removeAttribute("loggedIn");
                req.setAttribute("cause", ex.getCause());
                req.setAttribute("message", ex.getMessage());
                req.setAttribute("stackTrace", ex.getStackTrace());
                RequestDispatcher dispatcher = req.getRequestDispatcher(ex.getErrorTarget());
                dispatcher.forward(req, res);
            }catch(NullPointerException npe){
                req.setAttribute("message", "Couldn't execute command");
                out.println("blah");
            }finally{
                out.close();
            }
    }
}
