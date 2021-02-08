<%-- 
    Document   : update
    Created on : Dec 14, 2020, 3:17:39 PM
    Author     : nuwan_d
--%>
<%@page import="bean.GetBean"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RegisterServlet" method="post" onsubmit="return fn(1000)" name="f1">

            <div class="form-group row">
                <label for="Name" class="col-sm-2 col-form-label">
                    Name</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="uname"
                           placeholder="Enter name">
                </div>
            </div>

            <div class="form-group row">
                <label for="Password" class="col-sm-2 col-form-label">Password
                </label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="pw"
                           placeholder="Enter Password">
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Register</button>
        </form>
        <script type="text/javascript">
            function fn() {
                var str1 = f1.uname.value;
                var str2 = f1.pw.value;
                if (str1.length == 0 && str2.length == 0) {
                    alert("please enter user name and password");
                    return false;
                } else if (str1.length == 0 && str2.length != 0) {
                    alert("please enter username");
                    return false;
                } else if (str1.length != 0 && str2.length == 0) {
                    alert("please enter password");
                    return false;
                }
            }
        </script>
    </body>
</html>
