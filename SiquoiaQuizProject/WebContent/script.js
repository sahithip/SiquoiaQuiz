/* Document   : script
    Created on : 21-1-2013, 20:32:03
    Author     : Patrick Christensen
    Description:
    This file contains the standard scripts for the site SiQuoia
 */

$(document).ready(function(){
                $(".successbar").css("visibility", "hidden");
                $("#changepasswordbutton").css("background-color", "#e6e6e6", "text-shadow", "none").prop("disabled", true);
                $(".profilefield").prop("disabled", true);
                
                $("#menubutton1").click(function(){
                    window.location.href = "SiquoiaFrontController?command=home";
                });
                $(".menubutton").mouseenter(function(){
                    $(this).animate({paddingTop: "15px"}, 100);
                });
                $(".menubutton").mouseleave(function(){
                    $(this).animate({paddingTop: "7px"}, 100);
                });
                $(".menubutton").mousedown(function(){
                    $(this).addClass(".menuclicked");
                });
                $(".menubutton").mouseup(function(){
                    $(this).removeClass(".menuclicked");
                });
                $("#menubutton2").click(function(){
                    window.location.href = "SiquoiaFrontController?command=marketplace";
                });
                $("#menubutton3").click(function(){
                    window.location.href = "SiquoiaFrontController?command=submitquestion";
                });
                $("#menubutton4").click(function(){
                    window.location.href = "SiquoiaFrontController?command=browsequiz";
                });
                $("#menubutton5").click(function(){
                    var id = $("#userId").val();
                    window.location.href = "SiquoiaFrontController?command=profile&id="+id;
                });
                
                
                $("#editprofilebutton").click(function(){
                    if($("#editprofilebutton").text() === "Edit Profile"){
                        $(".profilefield").prop("disabled", false);
                        $("#changepasswordbutton").css("background-color", "#5e8ee4", "text-shadow", "1px 1px 5px #4173c9");
                        $("#editprofilebutton").text("Save");
                    }else{
                        var userId = $("#userId").val();
                        var userName = $("#usernamefield").val();
                        var email = $("#emailfield").val();
                        var firstName = $("#firstnamefield").val();
                        var middleName = $("#middlenamefield").val();
                        var lastName = $("#lastnamefield").val();
                        $.ajax({url: 
                            "SiquoiaFrontController?command=saveprofile"+
                            "&userId="+userId+
                            "&userName="+userName+
                            "&email="+email+
                            "&firstName="+firstName+
                            "&middleName="+middleName+
                            "&lastName="+lastName,
                            cache: false,
                            dataType: "json",
                            success: profileReady,
                            error: function(){
                                //TODO SEPARATE FUNCTION FOR SUCCESS MESSAGES FOR REUSABILITY
                                alert("Save failed");
                            }});
                        
                        $("input").prop("disabled", true);
                        $("#editprofilebutton").text("Edit Profile");
                    }
                });
                
                $("#nextquestionbutton").click(function(){
                    $.ajax({
                        url: "SiquoiaFrontController?command=NextQuestionAjaxCommand",
                        cache: false,
                        dataType: "json",
                        success: questionReady,
                        error: errorMessage("Couldn't load next question!")
                    });
                });
                
                function profileReady(data) {
                    $("#usernamefield").text(data.userName);
                    $("#emailfield").text(data.email);
                    $("#firstnamefield").text(data.firstName);
                    $("#middlenamefield").text(data.middleName);
                    $("#lastnamefield").text(data.lastName);
                    $("#changepasswordbutton").css("background-color", "#5e8ee4", "text-shadow", "1px 1px 5px #4173c9");
                    successMessage("Saved!");
                }
                
                function questionReady(data){
                    
                }
                
                function errorMessage(data){
                        $(".errorbar").slideUp();
                        $(".errorbar").css("visibility", "visible");
                        $(".errorbar").slideDown(function(){
                            $("#errormessage").text(data);
                        }).delay(2000).slideUp();
                }
                
                function successMessage(data){
                        $(".successbar").slideUp();
                        $(".successbar").css("visibility", "visible");
                        $(".successbar").slideDown(function(){
                            $("#successmessage").text(data);
                        }).delay(2000).slideUp();
                }
});
