/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.model;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Quiz extends QuizComponent{
    
	private long quizId;
    private ArrayList<Question> questions;
    private Category category;
    private User user;
    private int correctAnswers;
    
    public Quiz(long quizId, Category category, User user, int correctAnswers){
        this.quizId = quizId;
        this.category = category;
        this.user = user;
        this.correctAnswers = correctAnswers;
        questions = new ArrayList<Question>();
    }
    
    public Category getCategory() {
		return category;
	}
    
    public int getCorrectAnswers() {
		return correctAnswers;
	}
    
    public ArrayList<Question> getQuestions() {
		return questions;
	}
    
    public long getQuizId() {
		return quizId;
	}
    
    public User getUser() {
		return user;
	}
}
