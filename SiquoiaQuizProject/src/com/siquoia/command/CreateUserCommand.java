package com.siquoia.command;

import javax.servlet.http.HttpServletRequest;

import com.siquoia.exception.CommandException;
import com.siquoia.exception.ExistsException;
import com.siquoia.exception.NotPersistedException;
import com.siquoia.impl.UserImpl;
import com.siquoia.model.User;

public class CreateUserCommand extends TargetCommand{
	
	 private UserImpl userImpl = UserImpl.getInstance();

	    public CreateUserCommand(String target) {
	        super(target);
	    }

	    @Override
	    public String execute(HttpServletRequest request) throws CommandException {
	        String userName =   request.getParameter("userName");
	        String password =   request.getParameter("password");
	        String email =      request.getParameter("email");
	        String firstName =  request.getParameter("firstName");
	        String middleName = request.getParameter("middleName");
	        String lastName =   request.getParameter("lastName");
	        System.out.println(userName+"\n"+password);
	        
	        try {
				User user = userImpl.signUp(userName, password, email, firstName, middleName, lastName);
				request.getSession().setAttribute("loggedIn", user);
			} catch (NotPersistedException e) {
				System.out.println(e.getMessage());
				throw new CommandException("login.jsp", "Something went wrong, and the information was not saved", e);
			} catch (ExistsException e) {
				throw new CommandException("signup.jsp", "That user already exists", e);
			}
	        return super.execute(request);
	    }
}
