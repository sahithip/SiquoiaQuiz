package com.siquoia.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.siquoia.exception.CommandException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.impl.QuizImpl;
import com.siquoia.model.Category;

public class SubCategoryAjaxCommand extends AjaxCommand{

	@Override
	public String execute(HttpServletRequest request, String data) throws CommandException {
		Gson json = new Gson();
		long parentId = Long.parseLong(request.getParameter("parentId"));
		ArrayList<Category> subCategories = new ArrayList<Category>();
		try{
			subCategories = QuizImpl.getInstance().getSubCategories(parentId);
		}catch(NotFoundException nfe){
			throw new CommandException("login.jsp", nfe.getMessage(), nfe);
		}
		System.out.println(subCategories.toString());
		data = json.toJson(subCategories);
		return super.execute(request, data);
	}
}
