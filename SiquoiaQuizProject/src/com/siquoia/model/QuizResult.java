package com.siquoia.model;

import java.util.ArrayList;

public class QuizResult{

	private Achievement achievement;
	private Quiz quiz;
	
	public QuizResult(Quiz quiz, Achievement achievement){
		this.quiz = quiz;
		this.achievement = achievement;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public Achievement getAchievement() {
		return achievement;
	}
	
	public Category getCategory() {
		return quiz.getCategory();
	}
	
}
