<%@page import="com.siquoia.model.Question"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verify Question</title>
</head>
<body>
<form action="SiquoiaFrontController" method="post">
 <%ArrayList<Question> queList =null; %>
 <%if(request.getAttribute("queList") != null ){%>
	<% queList= (ArrayList<Question>)request.getAttribute("queList");%>
<%} %> 
<%if(queList.size()>0){ %>
<table border="1">
	<tr>
		<td>Category</td>
		<td>Question</td>
		<td>Option 1</td>
		<td>Option 2</td>
		<td>Option 3</td>
		<td>Correct Answer</td>
	</tr>
	<% for(int i=0;i<queList.size();i++){%>
	<tr>
	<td><%=queList.get(i).getCategoryName() %></td>
	<td> <%=queList.get(i).getQuestion() %></td>
	<td><%= queList.get(i).getOption1() %></td>
	<td><%= queList.get(i).getOption2() %></td>
	<td><%=queList.get(i).getOption3() %></td>
	<td><%= queList.get(i).getCorrectOption() %></td>
	<td><input type="checkbox" name="check" value="<%=queList.get(i).getQuestionId()%>"></td>
	</tr>
	<%} %>
	<tr>
		<td>
		 <button type="submit" name="command" value="verifyQue">Submit</button>
		</td>
	</tr>
</table>
<%} %>
</form>
</body>
</html>