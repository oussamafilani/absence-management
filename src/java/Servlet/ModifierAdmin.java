
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import Metier.Admin;
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "ModifierAdmin", urlPatterns = {"/ModifierAdmin"})
public class ModifierAdmin extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            if(request.getParameter("id")!=null){
                session.setAttribute("id", request.getParameter("id"));
                RequestDispatcher rd = request.getRequestDispatcher("modifierAdmin.jsp");
                rd.forward(request, response);
            }
            else if(request.getParameter("email")!=null){
                int id = Integer.parseInt(request.getParameter("idA"));
                if(request.getParameter("password").equals(request.getParameter("cpassword"))){
                    Admin a = new Admin(id,request.getParameter("pseudo"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"),
                    request.getParameter("password"));
                    if(dao.updatAdmin(a) && dao.updatUser(request.getParameter("pseudo"), request.getParameter("password"), id)){
                    request.setAttribute("msg","bien update");
                    RequestDispatcher rd = request.getRequestDispatcher("modifierAdmin.jsp");
                    rd.forward(request, response);
                    }
                    else{
                        request.setAttribute("msg","pas update");
                        RequestDispatcher rd = request.getRequestDispatcher("modifierAdmin.jsp");
                        rd.forward(request, response); 
                    }
                }
                else{
                    request.setAttribute("msg","les mot de passe ne sont pas compatible");
                    RequestDispatcher rd = request.getRequestDispatcher("modifierAdmin.jsp");
                    rd.forward(request, response); 
                }
            }
        }
    }

    

}
