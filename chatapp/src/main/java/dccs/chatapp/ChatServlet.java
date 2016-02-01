/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dccs.chatapp;

import dccs.chatapp.var.ChatObject;
import dccs.chatapp.var.Consts;
import dccs.chatapp.var.Message;
import dccs.chatapp.var.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ChatServlet", urlPatterns = {"/chat-servlet"})
public class ChatServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
       
        ChatObject chat = (ChatObject) context.getAttribute(Consts.USER_CHAT);
        User user = (User) request.getSession().getAttribute(Consts.USER);
        String name = user.getUser();
        String msg = request.getParameter("msgBox");
        msg = msg.trim();
        if (!msg.isEmpty())
        {
            synchronized (chat) {
                chat.messages.add(new Message(name, msg));
                chat.nom++;
            }
        }
        RequestDispatcher rd = context.getRequestDispatcher("/chatroom.jsp");
        rd.forward(request, response);
    }
}