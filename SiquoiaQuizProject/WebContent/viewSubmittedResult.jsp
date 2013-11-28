<%@page import="com.siquoia.model.Quiz"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Submitted Result</title>
</head>
<body>
<%ArrayList<Quiz> quizList = null ;%>
 <%if(request.getAttribute("quizList") != null ){%>
	<% quizList=(ArrayList<Quiz>)request.getAttribute("quizList");%>
<%} %>
<%if(quizList.size()>0){ %>
<table border="1">
	<tr>
		<td>Quiz Name</td>
		<td>User Name</td>
		<td>User First Name</td>
		<td>User Last Name</td>
		<td>Correct Answer</td>
	</tr>
	<% for(int i=0;i<quizList.size();i++){ %>
	<tr>
		<td><%=quizList.get(i).getQuizName() %></td>
		<td><%=quizList.get(i).getUserName() %></td>
		<td><%=quizList.get(i).getUserFName() %></td>
		<td><%=quizList.get(i).getUserLName() %></td>
		<td><%=quizList.get(i).getNoOfCorrectAns() %></td>
	</tr>
	<%} %>
</table>
<%} %>
</body>
</html>