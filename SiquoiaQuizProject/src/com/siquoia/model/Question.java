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
	private int questionId;
	private int categoryId;
	private String categoryName;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String correctOption;
    private String queVerified;
    private String submittedOption;
    
    
	
    public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	
	public String getQueVerified() {
		return queVerified;
	}
	public void setQueVerified(String queVerified) {
		this.queVerified = queVerified;
	}
	public String getSubmittedOption() {
		return submittedOption;
	}
	public void setSubmittedOption(String submittedOption) {
		this.submittedOption = submittedOption;
	}
    
    
    
    /*Constructor for submitting a question
    public Question(String question, String option1, String option2,
            String option3, String correctOption){
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctOption = correctOption;
    }
    
    Constructor for answering a question
    public Question(String question, String option1, String option2,
            String option3, String correctOption, String submittedOption){
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctOption = correctOption;
        this.submittedOption = submittedOption;
    }*/
    
    
}
