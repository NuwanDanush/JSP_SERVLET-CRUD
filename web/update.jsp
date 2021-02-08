<%-- 
    Document   : update.jsp
    Created on : Dec 15, 2020, 10:59:56 AM
    Author     : nuwan_d
--%>
<%@page import="bean.GetBean"%>
<% GetBean result = (GetBean) session.getAttribute("result");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String roll = (String) session.getAttribute("roll");
%>
<%
    String editflag = (String) session.getAttribute("editflag");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (editflag == "1") {%>  <!--if flag = 1 edit other user's profile-->
        <div class="container">
            <h1><b><center>Employee Update Form</center></b></h1>
            <%
                if (request.getAttribute("update") != null) {
                    out.println("<meta http-equiv='refresh' content='2;URL=ViewServlet'>");
                    out.println("<center><p style='color:green;'><b>Update Successfully!!!</b></p></center>");
                }
            %>
            <div class="card">
                <div class="card-body">
                    <form action="UpdateServlet" method="post" onsubmit="return fn()" name="f1">    
                        <span id="error"></span>
                        <div class="form-group row">
                            <label for="Name" class="col-sm-2 col-form-label">Name
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="uname"
                                       value="<%=result.getUsername()%>" readOnly=”true”>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="Phone" class="col-sm-2 col-form-label">Phone
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="phone"
                                       value="<%=result.getPhone()%>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="Password" class="col-sm-2 col-form-label">Email
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="email"
                                       value="<%=result.getEmail()%>">
                            </div>
                        </div>
                        <% if (roll.equals("1")) {%>
                        <div class="form-group row">
                            <label for="Roll" class="col-sm-2 col-form-label">Roll
                            </label>
                            <div class="col-sm-7">
                                <select name="roll" required>
                                    <option value="" selected disabled hidden>Choose here</option>
                                    <option value="1">Admin</option>
                                    <option value="2">Manager</option>
                                    <option value="3">User</option>
                                </select>
                            </div>
                        </div>
                        <%} else {%>
                        <div class="form-group row">
                            <input type="hidden" class="form-control" name="roll"
                                       value="<%=result.getRoll()%>">
                        </div>
                        <%}%>

                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Update</button>
                    </form><br>
                    <form action="ViewServlet" method="post">
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary" >Back</button>
                    </form>

                </div>
            </div>
        </div>
        <%} else if (editflag == "2") {%> <!--if flag = 2 edit other own profile-->
        <div class="container">
            <h1><b><center>User Profile Update Form</center></b></h1>
            <%
                if (request.getAttribute("update") != null) {
                    out.println("<meta http-equiv='refresh' content='2;URL=welcome.jsp'>");
                    out.println("<center><p style='color:green;'><b>Update Successfully!!!</b></p></center>");
                }
            %>
            <div class="card">
                <div class="card-body">
                    <form action="UpdateServlet" method="post" onsubmit="return fn()" name="f1">    
                        <span id="error"></span>
                        <div class="form-group row">
                            <label for="Name" class="col-sm-2 col-form-label">Name
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="uname"
                                       value="<%=result.getUsername()%>" readOnly=”true”>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="Phone" class="col-sm-2 col-form-label">Phone
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="phone"
                                       value="<%=result.getPhone()%>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="Password" class="col-sm-2 col-form-label">Email
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="email"
                                       value="<%=result.getEmail()%>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <input type="hidden" class="form-control" name="roll"
                                       value="<%=result.getRoll()%>">
                        </div>

                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary">Update</button>
                    </form><br>
                    <form action="welcome.jsp" method="post">
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary" >Back</button>
                    </form>

                </div>
            </div>
        </div>
        <%}%>

        <script type="text/javascript">
            function fn() {
                var phone = f1.phone.value;
                var email = f1.email.value;
                if (!(Validation(phone))) {
                    error.textContent = "Invalid phone number"
                    error.style.color = "red"
                    return false;
                } else if (!(ValidateEmail(email))) {
                    error.textContent = "Invalid email"
                    error.style.color = "red"
                    return false;
                }
//                email validation
                function ValidateEmail(uemail)
                {
                    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                    if (uemail.match(mailformat))
                    {
                        return true;
                    } else
                    {
                        return false;
                    }
                }
//                 phone number validation
                function Validation(phone) {
                    var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
                    if (phone.match(phoneno))
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        </script>
    </body>
</html>
