package com.siquoia.command;



import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.siquoia.exception.CommandException;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.RollBackException;
import com.siquoia.impl.QuizImpl;

public class GetResultAjaxCommand extends AjaxCommand{
	
	@Override
	public String execute(HttpServletRequest request, String data)
			throws CommandException {
		long quizId = Long.parseLong(request.getParameter("quizId"));
		Gson json = new Gson();
			try {
				data = json.toJson(QuizImpl.getInstance().getResult(quizId));
			} catch (NotFoundException e){
				throw new CommandException("login.jsp", e.getMessage(), e);
			}
		return super.execute(request, data);
	}
}
