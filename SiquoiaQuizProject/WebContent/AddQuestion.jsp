<%@page import="com.siquoia.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="SiquoiaFrontController" method="post">
 <%ArrayList<Category> categoryList = null ;%>
 <%if(request.getAttribute("categoryList") != null ){%>
	<% categoryList=(ArrayList<Category>)request.getAttribute("categoryList");%>
<%} %>
<table>
	<tr>
		<td><lable>Category Name:</lable></td>
		<td>
		<select name="categoryName">
		<%for (int i=0;i<categoryList.size();i++){ %>
		<option id="categoryId" value="<%= categoryList.get(i).getCategoryId()%>"><%= categoryList.get(i).getCategoryName() %></option>
		<%} %>
		</select>
		</td>
	</tr>
	<tr>
		<td><label>Question:</label></td>
		<td><input type="text" name="question" id="question"></td>
	</tr>
	<tr>
		<td><label>Option 1:</label></td>
		<td><input type="text" name="opt1" id="opt1"></td>
	</tr>
	<tr>
		<td><label>Option 2:</label></td>
		<td><input type="text" name="opt2" id="opt2"></td>
	</tr>
	<tr>
		<td><label>Option 3:</label></td>
		<td><input type="text" name="opt3" id="opt3"></td>
	</tr>
	<tr>
		<td><label>Correct Option:</label></td>
		<td><input type="text" name="correctOpt" id="correctOpt"></td>
	</tr>
	<tr>
		<td>
		 <button type="submit" name="command" value="addQue">Submit</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>