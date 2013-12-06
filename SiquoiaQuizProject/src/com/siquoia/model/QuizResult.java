package com.siquoia.model;

public class QuizResult{

	private Achievement achievement;
	private Quiz quiz;
	private Category category;
	
	public QuizResult(Quiz quiz, Achievement achievement){
		this.quiz = quiz;
		this.achievement = achievement;
		category = quiz.getCategory();
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public Achievement getAchievement() {
		return achievement;
	}
	
	public Category getCategory() {
		return category;
	}
	
}
