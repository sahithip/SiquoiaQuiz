package com.siquoia.impl;

import com.siquoia.control.DBManager;
import com.siquoia.exception.NotFoundException;
import com.siquoia.exception.RollBackException;
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
	
}
