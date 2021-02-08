<%-- 
    Document   : register.jsp
    Created on : Dec 8, 2020, 3:27:17 PM
    Author     : nuwan_d
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!--Register form-->
    <body>      
        <div class="container">
            <h1><b><center>Employee Register Form</center></b></h1>

            <%
                if (request.getAttribute("register") != null) {
                    out.println("<meta http-equiv='refresh' content='2;URL=register.jsp'>");
                    out.println("<center><p style='color:green;'><b>Register Successfully!!!</b></p></center>");
                }
            %>

            <div class="card">
                <div class="card-body">
                    <form action="RegisterServlet" method="post" onsubmit="return fn()" name="f1">     
                        <span id="error"></span>                        
                        <div class="form-group row">                           
                            <label for="Name" class="col-sm-2 col-form-label">Name
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="uname"
                                       placeholder="Enter Name" id="Username" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="Phone No" class="col-sm-2 col-form-label">Phone No
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="phone"
                                       placeholder="Enter Phone Number" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="Email" class="col-sm-2 col-form-label">Email
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="email"
                                       placeholder="Enter Email Address" required>
                            </div>
                        </div>
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
                        <div class="form-group row">
                            <label for="Password" class="col-sm-2 col-form-label">Password
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="pw"
                                       placeholder="Enter Password" id="Password" required>
                            </div>
                        </div>

                        <button style="background-color: black; border-color: black; width: 100px "  type="submit" class="btn btn-primary">Register</button>
                    </form><br>
                    <form action="login.jsp" method="post">
                        <h6>Already have an account? Click Login..</h6><br>
                        <button style="background-color: black; border-color: black; width: 100px" type="submit" class="btn btn-primary" >Login</button>
                    </form>

                </div>
            </div>
        </div>

        <!--can't register without one of field-->
        <script src="jquery-3.5.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript">

//            username check ajax function
                        $('#Username').change(function () {
                            var name = $(this).val();
                            var data = "name=" + name;
                            $.ajax({
                                url: 'CheckUsername',
                                data: data,
                                type: 'get',
                                success: function (response) {
                                    if (response == 1) {
//                                        error.textContent = "username already exist!!";
//                                        error.style.color = "red";
                                        alert("username already exist!!");
                                        $('#Username').val('');
                                        $('#Username').focus();
                                    }
                                }
                            });
                        });

                        function fn() {
                            var uname = f1.uname.value;
                            var pw = f1.pw.value;
                            var phone = f1.phone.value;
                            var email = f1.email.value;
                            if (uname == 0) {
                                error.textContent = "please enter valid user name";
                                error.style.color = "red";
                                return false;
                            } else if (uname.length == 0 && pw.length == 0) {
                                error.textContent = "please enter user name and password";
                                error.style.color = "red";
                                return false;
                            } else if (uname.length == 0 && pw.length != 0) {
                                error.textContent = "please enter username";
                                error.style.color = "red";
                                return false;
                            } else if (uname.length != 0 && pw.length == 0) {
                                error.textContent = "please enter password";
                                error.style.color = "red";
                                return false;
                            } else if (!(Validation(phone))) {
                                error.textContent = "Invalid phone number";
                                error.style.color = "red";
                                return false;
                            } else if (!(ValidateEmail(email))) {
                                error.textContent = "Invalid email";
                                error.style.color = "red";
                                return false;
                            }
<!-- Email validation function-->
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
<!-- phone number validation function-->
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
