
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
import Metier.Enseignant;
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "changeEnseignantRole", urlPatterns = {"/changeEnseignantRole"})
public class changeEnseignantRole extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            if(request.getParameter("id")!=null){
                session.setAttribute("idEnseignant",request.getParameter("id"));
                RequestDispatcher rd = request.getRequestDispatcher("chngEnRole.jsp");
                rd.forward(request, response);
            }
            if(request.getParameter("type")!=null){
                if(request.getParameter("type").equals("Etudiant")){
                    int id = Integer.parseInt(request.getParameter("idEn"));
                    Enseignant enseignant = dao.getEnseignantsById(id);
                    dao.updatUserType(id, "etudiant");
                    if(dao.enseignantToEtudiant(enseignant)){
                        if(dao.deletAffectEnsei(id)){
                            dao.deletEnseignat(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEnRole.jsp");
                            rd.forward(request, response);
                        }
                        else{
                            dao.deletEnseignat(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEnRole.jsp");
                            rd.forward(request, response);
                        }
                    }
                    else{
                        request.setAttribute("msg","pas changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngEnRole.jsp");
                        rd.forward(request, response);
                    }
                }
                else if(request.getParameter("type").equals("Admin")){
                    int id = Integer.parseInt(request.getParameter("idEn"));
                    Enseignant enseignant = dao.getEnseignantsById(id);
                    dao.updatUserType(id, "admin");
                    if(dao.enseignantToAdmin(enseignant)){
                        if(dao.deletAffectEnsei(id)){
                            dao.deletEnseignat(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEnRole.jsp");
                            rd.forward(request, response);
                        }
                        else{
                            dao.deletEnseignat(id);
                            request.setAttribute("msg","bien changement");
                            RequestDispatcher rd = request.getRequestDispatcher("chngEnRole.jsp");
                            rd.forward(request, response);
                        }
                    }
                    else{
                        request.setAttribute("msg","pas changement");
                        RequestDispatcher rd = request.getRequestDispatcher("chngEnRole.jsp");
                        rd.forward(request, response);
                    }
                }
            }          
        }
    }

   

}
