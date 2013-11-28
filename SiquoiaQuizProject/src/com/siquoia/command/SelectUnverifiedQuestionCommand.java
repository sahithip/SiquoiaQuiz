package com.siquoia.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.siquoia.exception.CommandException;
import com.siquoia.impl.QuestionImpl;
import com.siquoia.model.Category;
import com.siquoia.model.Question;


public class SelectUnverifiedQuestionCommand extends TargetCommand
		implements Command {

	private QuestionImpl questionImpl;
	
	public SelectUnverifiedQuestionCommand(String target) {
		super(target);
		questionImpl = new QuestionImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		// TODO Auto-generated method stub
		ArrayList<Question> queList = new ArrayList<>();
		
		queList = questionImpl.selectUnverifiedQue();
		System.out.println("question list:"+queList);
		
		request.setAttribute("queList", queList);
		
		return super.execute(request);
	}

}
