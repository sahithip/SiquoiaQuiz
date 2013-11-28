/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.siquoia.dbconnection.DBConnection;
import com.siquoia.model.Category;
import com.siquoia.model.Question;
import com.siquoia.model.Quiz;
import com.siquoia.model.QuizComponent;

/**
 *
 * @author PC
 */
public class QuizMapper {
    
    DBConnection dbConnection = new DBConnection();
    //TODO: Implement get -and set methods for this class
	public ArrayList<Category> selectCategory()
	{
		
		ArrayList<Category> categoryList = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		
		con = dbConnection.getConnection();
		try
		{
			statement = con.prepareStatement("select * from category");
			ResultSet resultSet= statement.executeQuery();
			while(resultSet.next())
			{
				Category category = new Category();
				category.setCategoryId(Integer.parseInt(resultSet.getString("category_id")));
				category.setParentId(Integer.parseInt(resultSet.getString("parent_id")));
				category.setCategoryName(resultSet.getString("name"));
				categoryList.add(category);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbConnection.closeConnection(con);
			dbConnection.closeStatement(statement);
		}
		return categoryList;
	}
	

	public String addQue(String userType,Question question)
	{
		String flag = "false";
		Connection con = null;
		PreparedStatement statement=null;
		
		con = dbConnection.getConnection();
		try
		{
			
				statement = con.prepareStatement("insert into question(category_id, question, option1, option2,option3,correct_option,que_verified) values(?,?,?,?,?,?,?)");
				statement.setInt(1, question.getCategoryId());
				statement.setString(2, question.getQuestion());
				statement.setString(3, question.getOption1());
				statement.setString(4, question.getOption2());
				statement.setString(5, question.getOption3());
				statement.setString(6, question.getCorrectOption());
				if(userType.equalsIgnoreCase("user"))
				{
				statement.setString(7, "unverified");
				}
				if(userType.equalsIgnoreCase("admin"))
				{
				statement.setString(7, "verified");
				}
				
				int check = statement.executeUpdate();
				
				if(check>0)
				{
					flag = "true";
				}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbConnection.closeConnection(con);
			dbConnection.closeStatement(statement);
		}
		return flag;
	}


	public ArrayList<Question> selectUnverifiedQue()
	{
		ArrayList<Question> questionList = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		PreparedStatement ps = null;
		
		
		con=dbConnection.getConnection();
		try 
		{
			statement = con.prepareStatement("select * from question where que_verified = ?");
			statement.setString(1, "unverified");
			
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				Question question = new Question();
				question.setQuestionId(Integer.parseInt(result.getString("question_id")));
				question.setCategoryId(Integer.parseInt(result.getString("category_id")));
				question.setQuestion(result.getString("question"));
				question.setOption1(result.getString("option1"));
				question.setOption2(result.getString("option2"));
				question.setOption3(result.getString("option3"));
				question.setCorrectOption(result.getString("correct_option"));
				question.setQueVerified(result.getString("que_verified"));
				questionList.add(question);
				
				ps = con.prepareStatement("select * from category where category_id = ?");
				ps.setInt(1, question.getCategoryId());
				
				ResultSet set = ps.executeQuery();
				if(set.next())
				{
					question.setCategoryName(set.getString("name"));
				}
			}
			
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbConnection.closeConnection(con);
			dbConnection.closeStatement(statement);
			dbConnection.closeStatement(ps);
		}
		return questionList;
	}
	
	public String verifyQue(String QueId[])
	{
		String flag = "false";
		Connection con = null;
		PreparedStatement statement=null;
		
		con = dbConnection.getConnection();
		
		try 
		{
			for(int i=0; i< QueId.length;i++)
			{
				statement = con.prepareStatement("update question set que_verified =? where question_id = ? ");
				statement.setString(1, "verified");
				statement.setInt(2, Integer.parseInt(QueId[i]));
				
				int check = statement.executeUpdate();
				
				if(check>0)
				{
					flag = "true";
				}
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public ArrayList<Quiz> viewSubmittedResult()
	{
		ArrayList<Quiz> quizList = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		PreparedStatement ps=null;
		
		con = dbConnection.getConnection();
		try
		{
			statement = con.prepareStatement("select * from quiz where user_id != ?");
			statement.setString(1, "");
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next())
			{
				Quiz quiz = new Quiz();
				quiz.setQuizId(Integer.parseInt(resultSet.getString("quiz_id")));
				quiz.setUserId(Integer.parseInt(resultSet.getString("user_id")));
				quiz.setNoOfCorrectAns(Integer.parseInt(resultSet.getString("correct_answers")));
				quiz.setQuizName(resultSet.getString("name"));
				quiz.setCategoryId(Integer.parseInt(resultSet.getString("category_id")));
				quizList.add(quiz);
				
				ps = con.prepareStatement("select * from user where user_id=?");
				ps.setInt(1, quiz.getUserId());
				
				ResultSet set = ps.executeQuery();
				
				if(set.next())
				{
					quiz.setUserName(set.getString("user_name"));
					quiz.setUserFName(set.getString("first_name"));
					quiz.setUserLName(set.getString("last_name"));
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbConnection.closeConnection(con);
			dbConnection.closeStatement(statement);
		}
		return quizList;
	}
}
