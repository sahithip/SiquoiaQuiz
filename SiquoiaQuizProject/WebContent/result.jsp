<%-- 
    Document   : shareresults
    Created on : 08-11-2013, 21:42:34
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link rel="stylesheet" href="style.css"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <script>
       		$(document).ready(function(){
       			
       			$.ajax({url: 
                    "SiquoiaFrontController?command=getresult",
                    cache: false,
                    dataType: "json",
                    success: scoreReady,
                    error: function(){
                    	alert("Couldn't fetch");
                    }});
       			
       			function scoreReady(data){
       				for(var i in data){
       					var result = data[i];
       					$(".resulttable").append("<tr><td>"+result.question+"</td>"+
       							"<td>"+result.answer+"</td>"+
       							"<td>"+result.isCorrect+"</td></tr>");
       				}
       			}
       		});
        </script>
    </head>
    <body>
<!--     FACEBOOK SCRIPT -->
<script>
          window.fbAsyncInit = function() {
            // init the FB JS SDK
            FB.init({
              appId      : 'SiQuoia',                        // App ID from the app dashboard
              status     : true,                                 // Check Facebook Login status
              xfbml      : true                                  // Look for social plugins on the page
            });

            // Additional initialization code such as adding Event Listeners goes here
          };

          // Load the SDK asynchronously
          (function(){
             // If we've already installed the SDK, we're done
             if (document.getElementById('facebook-jssdk')) {return;}

             // Get the first script element, which we'll use to find the parent node
             var firstScriptElement = document.getElementsByTagName('script')[0];

             // Create a new script element and set its id
             var facebookJS = document.createElement('script'); 
             facebookJS.id = 'facebook-jssdk';

             // Set the new script's source to the source of the Facebook JS SDK
             facebookJS.src = '//connect.facebook.net/en_US/all.js';

             // Insert the Facebook JS SDK into the DOM
             firstScriptElement.parentNode.insertBefore(facebookJS, firstScriptElement);
           }());
        </script>
        <div class="top">
            <div class="logos">
                <h1>SiQuoia</h1>
            </div>
        </div>
        
        <div class="content">
        <center>
            <h2>Result of Quiz</h2>
            <table class="resulttable">
            	<th colspan="3">Score</th>
            	<tr style="background: #c6ccf9;">
            		<td>Question</td>
            		<td>Submitted Answer</td>
            		<td>Correct?</td>
            	</tr>
            </table>
        </center>
            <div class="fb-share-button" data-href="http://www.siquoia.com" data-type="box"></div>
        <div class="bot">
                <p>SiQuoia © - 2013</p>
        </div>
        </div>
        
        
    </body>
</html>
