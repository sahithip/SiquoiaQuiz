package com.siquoia.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.siquoia.exception.CommandException;
import com.siquoia.impl.QuestionImpl;
import com.siquoia.model.Question;
import com.siquoia.model.Quiz;

public class ViewSubmitedResultCommand extends TargetCommand implements Command{

	private QuestionImpl questionImpl;
	
	public ViewSubmitedResultCommand(String target) {
		super(target);
		questionImpl = new QuestionImpl();
		// TODO Auto-generated constructor stub
	}

	public String execute(HttpServletRequest request) throws CommandException {
		// TODO Auto-generated method stub
		ArrayList<Quiz> quizList = new ArrayList<>();
		
		quizList = questionImpl.viewSubmittedResult();
		System.out.println("question list:"+quizList);
		
		request.setAttribute("quizList", quizList);
		
		return super.execute(request);
	}
}
