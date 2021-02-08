<%-- 
    Document   : welcome
    Created on : Dec 30, 2020, 8:56:07 AM
    Author     : nuwan_d
--%>

<%
    String user = (String) session.getAttribute("user");
%>
<%
    String roll = (String) session.getAttribute("roll");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-body">

                    <%if (roll.equals("1")) {%>
                    <h1><b><center>Welcome to Admin Dashboard</center></b></h1>
                    <h3><center>___Hello <%=user%>___</center></h3><br>
                    <form action="ViewServlet" method="post">  <!--If click View User button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">View Users</button>
                    </form><br> 
                    <form action="FindByUserServlet" method="post"> <!--if click edit profile button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Edit Profile</button>
                    </form><br>
                    <form action="LogoutServlet"> <!--If click Logout button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Logout</button>
                    </form> 
                    <%} else if (roll.equals("2")) {%>
                    <h1><b><center>Welcome to Manager Dashboard</center></b></h1>
                    <h3><center>___Hello <%=user%>___</center></h3><br>
                    <form action="ViewServlet" method="post">  <!--If click View User button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">View Users</button>
                    </form><br> 
                    <form action="FindByUserServlet" method="post"> <!--if click edit profile button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Edit Profile</button>
                    </form><br>
                    <form action="LogoutServlet"> <!--If click Logout button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Logout</button>
                    </form>
                    <%} else if (roll.equals("3")) {%>
                    <h1><b><center>Welcome to User Dashboard</center></b></h1>
                    <h3><center>___Hello <%=user%>___</center></h3><br>
                    <form action="ViewServlet" method="post">  <!--If click View User button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">View Users</button>
                    </form><br> 
                    <form action="FindByUserServlet" method="post"> <!--if click edit profile button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Edit Profile</button>
                    </form><br>
                    <form action="LogoutServlet"> <!--If click Logout button-->
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Logout</button>
                    </form>
                    <% }%>
                </div>
            </div>
        </div>
    </body>
</html>
