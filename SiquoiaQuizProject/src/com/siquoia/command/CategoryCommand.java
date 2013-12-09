package com.siquoia.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.siquoia.exception.CommandException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.impl.QuizImpl;
import com.siquoia.model.Category;

public class CategoryCommand extends TargetCommand{
	
	QuizImpl quizImpl = QuizImpl.getInstance();
	
	public CategoryCommand(String target) {
		super(target);
	}

	public String execute(HttpServletRequest request) throws CommandException {
		ArrayList<Category> categories;
		try{
			categories = quizImpl.getCategories();
		}catch(NotFoundException nfe){
			throw new CommandException("login.jsp", nfe.getMessage(), nfe);
		}
		
		request.setAttribute("categories", categories);
		return super.execute(request);
	}
	
	

}
