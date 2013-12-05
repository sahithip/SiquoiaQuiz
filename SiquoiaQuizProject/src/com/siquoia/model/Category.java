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
public class Category extends QuizComponent{
    
	private long categoryId;
	private String name;
	private ArrayList<Category> subCategories;
	
	public Category(long categoryId, String name, ArrayList<Category> subCategories){
		this.categoryId = categoryId;
		this.name = name;
		this.subCategories = subCategories;
	}
	
	public ArrayList<Category> getSubCategories(){
		return subCategories;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSubCategories(ArrayList<Category> subCategories) {
		this.subCategories = subCategories;
	}
}
