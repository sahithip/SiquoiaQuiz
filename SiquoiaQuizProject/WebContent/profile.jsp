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
        <title>Profile - SiQuoia</title>
        <link rel="stylesheet" href="style.css"/>
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
            <h2>Profile</h2>
            <div class="pagecontent"> 
                    <table class="profileedit">
                        <th id="account" colspan="2">Account Details</th>
                        <tr>
                            <td>User name:</td>
                            <td><input class="profilefield" id="usernamefield" type="textfield" value="${user.userName}"/></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input class="profilefield" id="emailfield" type="textfield" value="${user.email}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button id="changepasswordbutton">Change password</button></td>
                        </tr>
                        <th id="personal" colspan="2">Personal Details</th>
                        <tr> 
                            <td>First name:</td>
                            <td><input class="profilefield" id="firstnamefield" type="textfield" value="${user.firstName}"/></td>
                        </tr>
                        <tr>
                            <td>Middle name:</td>
                            <td><input class="profilefield" id="middlenamefield" type="textfield" value="${user.middleName}"/></td>
                        </tr>
                        <tr>
                            <td>Last name:</td>
                            <td><input class="profilefield" id="lastnamefield" type="textfield" value="${user.lastName}"/></td>
                        </tr>
                        <tr colspan="2">
                            <td></td>
                            <td>
                            <button id="editprofilebutton" style="width: 100px">Edit Profile</button>
                            </td>
                        </tr>
                    </table>
                
            </div>
            
            <div class="bot">
                <p>SiQuoia © - 2013</p>
            </div>
        </div>
        
    </body>
</html>
