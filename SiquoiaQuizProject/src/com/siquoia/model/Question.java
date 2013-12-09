/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.model;

/**
 * WE NEED TO CHANGE THIS CLASS' ATTRIBUTES TO BE MORE OBJECT-
 * ORIENTED
 * @author PC
 */
public class Question {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String correctOption;
    private String submittedOption;
    private boolean correct;
    
    /*Constructor for submitting a question*/
    public Question(String question, String option1, String option2,
            String option3, String correctOption){
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctOption = correctOption;
    }
    
    /*Constructor for answering a question*/
    public Question(String question, String option1, String option2,
            String option3, String correctOption, String submittedOption){
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctOption = correctOption;
        this.submittedOption = submittedOption;
        this.correct = submittedOption.equalsIgnoreCase(correctOption);
    }
    
    public String getQuestion() {
		return question;
	}
    
    public String getSubmittedOption() {
		return submittedOption;
	}
    
    public boolean isCorrect(){
    	return correct;
    }
    
    
}
