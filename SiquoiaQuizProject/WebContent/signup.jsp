<%-- 
    Document   : index
    Created on : 20-09-2013, 11:31:40
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up - SiQuoia</title>
        <script src="http://code.jquery.com/jquery-2.0.0.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <script src="script.js"></script>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div class="top">
            <div class="logos">
                <h1>SiQuoia</h1>
            </div>
        </div>
        <div class="content">
            <div class="menu"></div>
            <div id="formbody">
                <h2>
                    Sign up
                </h2>
                <div id="formcontent">
                        <table>
                            <tr>
                                <th>Account details</th>
                            </tr>
                            <tr>
                                <td>
                                Username:<input id="userName" placeholder="Username" type="text" style="width:100%"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                Email:<input id="email" placeholder="Email" type="text" style="width:100%"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                Password:<input id="password" placeholder="Password" type="password" style="width:100%"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                Repeat password:<input id="password2" placeholder="Repeat Password" type="password" style="width:100%"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Personal information</th>
                            </tr>
                            <tr>
                                <td>
                                    First name:<input id="firstName" placeholder="First Name" type="textfield" style="width:100%"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Middle name:<input id="middleName" placeholder="Middle Name" type="textfield" style="width:100%"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Last name:<input id="lastName" placeholder="Last Name" type="textfield" style="width:100%"/>
                                </td>
                            </tr>
                            <tr>
                                <td><button id="signupbutton">Sign up</button></td>
                                <td><button id="signupcancelbutton">Cancel</button></td>
                            </tr>
                        </table>
                </div>
            </div>
            <div class="bot">
                <p>SiQuoia © - 2013</p>
            </div>
        </div>
    </body>
</html>
