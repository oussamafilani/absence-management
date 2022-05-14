
package Servlet;

import DAO.DAO;
import Metier.Absence;
import Metier.Etudiant;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "etudiant", urlPatterns = {"/etudiant"})
public class etudiant extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String path=request.getServletPath();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            int id =dao.getUserId(request.getParameter("username"));
            Etudiant etudiant = dao.getEtudiantsById(id);
            ArrayList<Absence> table = dao.getEtudiantAbs(id);
            session.setAttribute("abs", table);
            session.setAttribute("etd", etudiant);
            rd = request.getRequestDispatcher("etudiant.jsp");
            rd.forward(request, response);
        }
    }

    

}
