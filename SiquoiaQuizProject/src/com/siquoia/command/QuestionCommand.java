package com.siquoia.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.siquoia.exception.CommandException;
import com.siquoia.impl.QuestionImpl;
import com.siquoia.model.Category;
import com.siquoia.model.Question;

public class QuestionCommand extends TargetCommand implements Command{
	
	private QuestionImpl questionImpl;

	public QuestionCommand(String target) {
		super(target);
		questionImpl = new QuestionImpl();
		// TODO Auto-generated constructor stub
	}

	public String execute(HttpServletRequest request) throws CommandException {
		
		Question questionObj= new Question();
		String flag = "false";
		
		//String userType = request.getParameter("userType");
		String userType = "admin";
		String categoryId = request.getParameter("categoryName");
		System.out.println("category is in command:"+categoryId);
		String question = request.getParameter("question");
		String option1 = request.getParameter("opt1");
		String option2 = request.getParameter("opt2");
		String option3 = request.getParameter("opt3");
		String correctOpt = request.getParameter("correctOpt");
		
		questionObj.setCategoryId(Integer.parseInt(categoryId));
		questionObj.setQuestion(question);
		questionObj.setOption1(option1);
		questionObj.setOption2(option2);
		questionObj.setOption3(option3);
		questionObj.setCorrectOption(correctOpt);
		
		
		flag = questionImpl.addQue(userType, questionObj);
		
		request.setAttribute("flag", flag);
		return super.execute(request);
	}
	
	/*public Category selectCategory()
	{
		Category category = questionImpl.selectCategory();
		
		return category;
	}*/
	
}
