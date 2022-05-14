
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
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "supprimerEnseignant", urlPatterns = {"/supprimerEnseignant"})
public class supprimerEnseignant extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            int id = Integer.parseInt(request.getParameter("id"));
            if(dao.deletAffectEnsei(id)){
                if(dao.deletEnseignat(id)){
                   RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                   rd.forward(request, response); 
                }
            }    
        }
    }

    

}
