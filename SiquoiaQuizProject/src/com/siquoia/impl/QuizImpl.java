package com.siquoia.impl;

import java.util.ArrayList;

import com.siquoia.control.DBManager;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.RollBackException;
import com.siquoia.model.Category;
import com.siquoia.model.QuizResult;

public class QuizImpl {
	
	DBManager manager = DBManager.getInstance();
	
	private static QuizImpl instance;
	
	public static QuizImpl getInstance(){
		if(instance == null)
			instance = new QuizImpl();
		return instance;
	}
	
	public QuizResult getResult(long quizId) throws NotFoundException{
		try{
			return manager.getResult(quizId);
		}catch(RollBackException rbe){
			throw new NotFoundException(quizId, rbe.getMessage());
		}
	}
	
	public ArrayList<Category> getSubCategories(long parentId) throws NotFoundException{
		try{
			return manager.getSubCategories(parentId);
		}catch(RollBackException rbe){
			throw new NotFoundException(parentId, rbe.getMessage());
		}
	}
	
	public ArrayList<Category> getCategories() throws NotFoundException{
		try{
			return manager.getCategories();
		}catch(RollBackException rbe){
			throw new NotFoundException(0L, rbe.getMessage());
		}
	}
	
}
