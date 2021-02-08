<%-- 
    Document   : searchView
    Created on : Dec 23, 2020, 5:43:41 PM
    Author     : nuwan_d
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="bean.GetBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ArrayList<GetBean> allUsers = (ArrayList<GetBean>) session.getAttribute("Allusers");
%>
<%
    String roll = (String) session.getAttribute("roll");
%>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">  
            <h2><center>-----List Of Users-----</center></h2>
            <form action="SearchServlet" method="post">   
                <div class="form-group row"><br><br>
                    <button style="background-color: black; border-color: black; width: 100px "  type="submit" class="btn btn-primary">Search</button>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="name"
                               placeholder="Enter Name" required>
                    </div>
                </div>

            </form>
            <table class="table table-hover">

                <tr>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Roll</th>
                        <% if (!(roll.equals("3"))) {%>
                    <th>Action</th>  
                        <%}%>    
                </tr>
                <!--set arraylist values in to the table-->
                <% for (int i = 0; i < allUsers.size(); i += 1) {%> 
                <tr>      
                    <td><%=allUsers.get(i).getUsername()%></td>
                    <td><%=allUsers.get(i).getPhone()%></td>
                    <td><%=allUsers.get(i).getEmail()%></td>
                    <td><%=allUsers.get(i).getRoll()%></td>
                    <% if (!(roll.equals("3"))) {%>
                    <td>
                        <a href="FindByUserServlet?username=<%=allUsers.get(i).getUsername()%>">Edit</a>    
                        <a href="DeleteServlet?username=<%=allUsers.get(i).getUsername()%>" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>
                    </td>
                    <%}%>
                </tr>
                <% }%>
            </table>
            <form action="ViewServlet" method="post">
                <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary" >Back</button>
            </form>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>            
        </div>
    </body>
</html>

