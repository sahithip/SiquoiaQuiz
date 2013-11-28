package com.siquoia.impl;

import java.util.ArrayList;

import com.siquoia.control.DBManager;
import com.siquoia.mapper.QuizMapper;
import com.siquoia.model.Category;
import com.siquoia.model.Question;
import com.siquoia.model.Quiz;

public class QuestionImpl {
	
	DBManager manager = DBManager.getInstance();
	QuizMapper   qMapper = new QuizMapper();
	
	public ArrayList<Category> selectCategory()
	{
		ArrayList<Category> categoryList = new ArrayList<>();
		categoryList = qMapper.selectCategory();
    	return categoryList;
	}

	public String addQue(String userType,Question question)
	{
		String flag = "false";
		flag = qMapper.addQue(userType, question);
		return flag;
	}
	
	public ArrayList<Question> selectUnverifiedQue()
	{
		ArrayList<Question> questionList = new ArrayList<>();
		questionList = qMapper.selectUnverifiedQue();
		return questionList;
	}
	
	public String verifyQue(String QueId[])
	{
		String flag = "false";
		flag = qMapper.verifyQue(QueId);
		return flag;
	}
	
	public ArrayList<Quiz> viewSubmittedResult()
	{
		ArrayList<Quiz> quizList = new ArrayList<>();
		quizList = qMapper.viewSubmittedResult();
		return quizList;
	}
}
