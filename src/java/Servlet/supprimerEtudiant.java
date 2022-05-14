
package Servlet;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "supprimerEtudiant_1", urlPatterns = {"/supprimerEtudiant_1"})
public class supprimerEtudiant extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            int id = Integer.parseInt(request.getParameter("id"));
            if(dao.deletEtudierEtudiant(id)){
                if(dao.deletEtudiant(id)){
                    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);
                } 
            }   
        }
    }

    

}
