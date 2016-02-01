<%@page import="dccs.chatapp.var.Consts"%>
<%@page import="dccs.chatapp.var.ChatObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stylesheet.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChatRoom Page</title>
      <!--  <script type="text/JavaScript">
            function TimedRefresh( t ) {
            setTimeout("location.href = '/chatapp/chatroom.jsp'", t);
            }
        </script> -->
    </head>
    
    <body <!--onload="TimedRefresh(3000);"-->
        <h2> My Chat APP!  </h2>
        <form action="/chatapp/chat-servlet" method="POST">
            <%-- <p> --%>
                <!--<textarea name="chatArea" rows="13" cols="60"> -->
            <%
                ChatObject chat = (ChatObject) application.getAttribute(Consts.USER_CHAT);

                for (int i = 0; i < chat.nom; i++) {
                    out.println(chat.messages.get(i).name);
            %> 
            <input type="text" value="<%out.println(chat.messages.get(i).message);%>" disabled="disabled" size="<%out.println(chat.messages.get(i).length);%>">
            <br>
            <br>
            <%
                }
            %>
             <!--</textarea> -->
            <br>
            <!-- <input type="text" name="msgBox" size="60"/> -->
            <h5>User: <%out.println(request.getSession().getAttribute(Consts.USER.toString()));%></h5>
            <textarea rows="2" cols="50" name="msgBox" autofocus="true">
                </textarea> 
            <input type="submit" name="send_msg" value="Send" width="40px"/>  
            <input type="button" name="refresh_page" value="Refresh" width="40" onclick="window.location.href = '/chatapp/chatroom.jsp'"/> 
        </p>
    </form>
</body>
</html>
