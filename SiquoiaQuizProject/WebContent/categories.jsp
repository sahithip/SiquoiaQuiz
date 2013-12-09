<%-- 
    Document   : home
    Created on : 15-10-2013, 22:26:39
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Categories - SiQuoia</title>
        <link rel="stylesheet" href="style.css"/>
        <script src="http://code.jquery.com/jquery-2.0.0.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <script src="script.js"></script>
        
    </head>
    <body>
    	<input id="categories" type="hidden" value="${categories}"/>
        <input id="userId" type="hidden" value="${loggedIn.userId}"/>
        <div class="top">
            <div class="logos">
                <h1>SiQuoia</h1>
            </div>
        </div>
        <div class="content">
            <div class="menu">
                <div class="menubutton" id="menubutton1">
                    Home
                </div>
                <div class="menubutton" id="menubutton2">
                    Market Place
                </div>
                <div class="menubutton" id="menubutton3">
                    Submit Question
                </div>
                <div class="menubutton" id="menubutton4">
                    Play
                </div>
                <div class="menubutton" id="menubutton5">
                    Profile
                </div>
            </div>
            <div class="pagecontent">
                <h2>Category browser</h2>
                <table class="categorytable">
                	<c:forEach var="category" items="${categories}">
	                	<c:choose>
                		<c:when test="${empty category.subCategories}">
	                	</c:when>
	                	<c:otherwise>
	                		<td class="categorybutton" id="${category.categoryId}"><c:out value="${category.name}"></c:out></td>
	                	</c:otherwise>
	                	</c:choose>
                	</c:forEach>
                </table>
            </div>
            
            <div class="bot">
                <p>SiQuoia © - 2013</p>
            </div>
        </div>
        
    </body>
</html>
