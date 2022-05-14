
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
import Metier.Etudiant;
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "changeEtudiantRole_1", urlPatterns = {"/changeEtudiantRole_1"})
public class changeEtudiantRole extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            if(request.getParameter("id")!=null){
                session.setAttribute("idEtudiant",request.getParameter("id"));
                RequestDispatcher rd = request.getRequestDispatcher("chngEtRole.jsp");
                rd.forward(request, response);
            }
            if(request.getParameter("type")!=null){
                if(request.getParameter("type").equals("Enseignant")){
                    int id = Integer.parseInt(request.getParameter("idE"));
                    Etudiant etudiant = dao.getEtudiantsById(id);
                    dao.updatUserType(id, "enseignant");
                    if(dao.etudiantToEnseignant(etudiant)){
                        if(dao.deletEtudierEtudiant(id)){
                            dao.deletEtudiant(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEtRole.jsp");
                            rd.forward(request, response);
                        }
                        else{
                            dao.deletEtudiant(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEtRole.jsp");
                            rd.forward(request, response);
                        }
                    }
                    else{
                        request.setAttribute("msg","pas changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngEtRole.jsp");
                        rd.forward(request, response);
                    }
                }
                else if(request.getParameter("type").equals("Admin")){
                    int id = Integer.parseInt(request.getParameter("idE"));
                    Etudiant etudiant = dao.getEtudiantsById(id);
                    dao.updatUserType(id, "admin");
                    if(dao.etudiantToAdmin(etudiant)){
                        if(dao.deletEtudierEtudiant(id)){
                            dao.deletEtudiant(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEtRole.jsp");
                            rd.forward(request, response);
                        }
                        else{
                            dao.deletEtudiant(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEtRole.jsp");
                            rd.forward(request, response);
                        }
                    }
                    else{
                        request.setAttribute("msg","pas changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngEtRole.jsp");
                        rd.forward(request, response);
                    }
                }
            }      
        }
    }

   

}
