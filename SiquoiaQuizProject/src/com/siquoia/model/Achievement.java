/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.model;

/**
 *
 * @author PC
 */
public class Achievement {
	
	private long achievementId;
    private long numberPlayedQuizzes;
    private long submitLevel;
    private long answerLevel;
    private long noOfTitles;
    private long rewardPoints;
    
    public Achievement(long achievementId, long numberPlayedQuizzes, long submitLevel, long answerLevel,
    		long noOfTitles, long rewardPoints){
        this.achievementId = achievementId;
    	this.numberPlayedQuizzes = numberPlayedQuizzes;
        this.submitLevel = submitLevel;
        this.answerLevel = answerLevel;
        this.noOfTitles = noOfTitles;
        this.rewardPoints = rewardPoints;
    }
    
    public long getAchievementId() {
		return achievementId;
	}
    
    public long getAnswerLevel() {
		return answerLevel;
	}
    
    public long getNoOfTitles() {
		return noOfTitles;
	}
    
    public long getNumberPlayedQuizzes() {
		return numberPlayedQuizzes;
	}
    
    public long getRewardPoints() {
		return rewardPoints;
	}
    
    public long getSubmitLevel() {
		return submitLevel;
	}
}
