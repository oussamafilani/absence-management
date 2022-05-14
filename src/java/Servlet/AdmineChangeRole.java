
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
@WebServlet(name = "AdmineChangeRole", urlPatterns = {"/AdmineChangeRole"})
public class AdmineChangeRole extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            if(request.getParameter("id")!=null){
                session.setAttribute("idAdmin",request.getParameter("id"));
                RequestDispatcher rd = request.getRequestDispatcher("chngRole.jsp");
                rd.forward(request, response);
            }
            if(request.getParameter("type")!=null){
                if(request.getParameter("type").equals("Enseignant")){
                    int id = Integer.parseInt(request.getParameter("idA"));
                    Admin admin = dao.getAdminsById(id);
                    dao.updatUserType(id, "enseignant");
                    if(dao.adminToEnseignant(admin)){
                        dao.deletAdmin(id);
                        request.setAttribute("msg","bien changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngRole.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        request.setAttribute("msg","pas changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngRole.jsp");
                        rd.forward(request, response);
                    }
                }
                else if(request.getParameter("type").equals("Etudiant")){
                    int id = Integer.parseInt(request.getParameter("idA"));
                    Admin admin = dao.getAdminsById(id);
                    dao.updatUserType(id, "etudiant");
                    if(dao.adminToEtudiant(admin)){
                        dao.deletAdmin(id); 
                        request.setAttribute("msg","bien changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngRole.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        request.setAttribute("msg","pas changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngRole.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        }
    }

    

}
