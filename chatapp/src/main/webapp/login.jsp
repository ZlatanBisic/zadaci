<%@page import="dccs.chatapp.var.Consts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <FORM ACTION="/chatapp/session-initialize" METHOD="POST">
            <h2> My Chat APP! </h2>
            <div style="left: 20%">Username: <br> 
                <p>
                    <INPUT TYPE="TEXT" NAME="userText"> 
                    <INPUT TYPE="SUBMIT" value="Login">
                </p> 

                <% if (Consts.nesto != 0) { %>
                <div style="color: red; font-size: 12px"> Please insert username! </div>
                <% } %>
                <% if (Consts.nesh != 0) { %>
                <div style="color: red; font-size: 12px"> Username already exist! </div>
                <% }%>
        </form>
    </body>
</html>
