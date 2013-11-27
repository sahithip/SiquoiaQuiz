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
        <title>My quizzes - SiQuoia</title>
        <link rel="stylesheet" href="style.css"/>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <script src="script.js"></script>
    </head>
    <body>
        <input id="userId" type="hidden" value="${loggedIn.userId}"/>
        <div class="successbar">
            <div id="successmessage"></div>
        </div>
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
            <h2>My Quizzes</h2>
            <div class="pagecontent">
                <c:forEach var="quiz" items="${quizzes}">
                    <option value="${quiz.id}" data-record="${quiz.id}">
                        <c:out value="${quiz.name}"></c:out>
                    </option>
                </c:forEach>
            </div>
            
            <div class="bot">
                <p>SiQuoia © - 2013</p>
            </div>
        </div>
        
    </body>
</html>
