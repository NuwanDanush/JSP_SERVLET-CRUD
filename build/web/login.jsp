<%-- 
    Document   : login.jsp
    Created on : Dec 8, 2020, 3:07:03 PM
    Author     : nuwan_d
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String loginError = (String) request.getAttribute("loginError");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1><b><center>Employee Login Form</center></b></h1>
            <div class="card">
                <div class="card-body">
                    <form class="login" action="LoginServlet" method="post" >                                           
                        <div class="form-group row">
                            <label for="Name" class="col-sm-2 col-form-label">User Name
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="uname"
                                       placeholder="Enter name" id="Username">
                            </div>
                        </div>                       
                        <div class="form-group row">
                            <label for="Password" class="col-sm-2 col-form-label">Password
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="pw"
                                       placeholder="Enter Password" id="Password">
                            </div>
                        </div>
                        <div id="message-here"></div>

                        <div style="text-align: center;">
                            <%
                                if (request.getAttribute("loginError") != null) {
                                    out.println("<meta http-equiv='refresh' content='2;URL=login.jsp'>");
                                    out.println("<p style='color:red;'><b>Invalid Username or Password!!</b></p>");
                                }
                            %>                           
                        </div>

                        <button style="background-color: black; border-color: black; width: 100px " type="submit" class="btn btn-primary" id="login">Login</button>                     
                    </form><br>

                    <form action="register.jsp" method="post">
                        <h6>Don't have an account? Click Register..</h6><br>
                        <button style="background-color: black; border-color: black; width: 100px " type="submit" class="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>