package dccs.chatapp;

import dccs.chatapp.var.ChatObject;
import dccs.chatapp.var.Consts;
import dccs.chatapp.var.User;
import dccs.chatapp.var.UserSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SessionInitialize", urlPatterns = {"/session-initialize"})
public class SessionInitialize extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }
    
     /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        ServletContext context = getServletContext();
        String name = request.getParameter("userText");
        if (!name.isEmpty())
        {
            name = name.trim();
            int pom=0;
            if (context.getAttribute(Consts.USER_SESSION) != null)
            {
                UserSession user = (UserSession) context.getAttribute(Consts.USER_SESSION);
                for (int i=0; i<user.username.size(); i++)
                {
                    if (user.username.get(i).equals(name)) {
                        pom=1;
                        break;
                    }
                }
                if (pom !=1)
                {
                    user.username.add(name);
                    request.getSession().setAttribute(Consts.USER, new User(name));
                }    
                else
                {
                    Consts.nesh = 1;
                    Consts.nesto = 0;
                    RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                }
                
            }
            else
            {
                context.setAttribute(Consts.USER_SESSION, new UserSession(name));
                request.getSession().setAttribute(Consts.USER, new User(name));
            }
            
            
            if (context.getAttribute(Consts.USER_CHAT) != null)
                context.setAttribute(Consts.USER_CHAT, context.getAttribute(Consts.USER_CHAT));
            else
                context.setAttribute(Consts.USER_CHAT, new ChatObject());
            
            Consts.nesto = 0;
            Consts.nesh = 0;
            RequestDispatcher rd = context.getRequestDispatcher("/chatroom.jsp");
            rd.forward(request, response);
        }
        else
        {
            //response.sendRedirect("/login.jsp");
            //response.sendError(SC_CONFLICT, "Please insert Username!");
            Consts.nesto = 1;
            Consts.nesh = 0;
            RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
            
        }

    }
}