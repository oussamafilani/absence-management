
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
@WebServlet(name = "modifierEtudiant_1", urlPatterns = {"/modifierEtudiant_1"})
public class modifierEtudiant extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher("modifierEt.jsp");
        try (PrintWriter out = response.getWriter()) {
          dao.getConnection();
            if(request.getParameter("id")!=null){
                session.setAttribute("id", request.getParameter("id"));
                rd.forward(request, response);
            }
            else if(request.getParameter("email")!=null){
                int id = Integer.parseInt(request.getParameter("idEt"));
                if(request.getParameter("password").equals(request.getParameter("cpassword"))){                    
                    Etudiant etudiant = new Etudiant(id,request.getParameter("cne"),request.getParameter("nom"),request.getParameter("prenom"),
                            request.getParameter("date_naiss"),request.getParameter("ville_naiss"),request.getParameter("adrs")
                            ,request.getParameter("ville"),request.getParameter("email"),request.getParameter("phone"));
                    if(dao.updatEtudiant(etudiant) && dao.updatUser(request.getParameter("pseudo"), request.getParameter("password"), id)){
                        request.setAttribute("msg","bien update");
                        //RequestDispatcher rd = request.getRequestDispatcher("modifierEt.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        request.setAttribute("msg","pas update");
                        //RequestDispatcher rd = request.getRequestDispatcher("modifierEt.jsp");
                        rd.forward(request, response); 
                    }
                }
                else{
                    request.setAttribute("msg","les mot de passe ne sont pas compatible");
                    //RequestDispatcher rd = request.getRequestDispatcher("modifierEt.jsp");
                    rd.forward(request, response); 
                }
            }  
        }
    }

    

}
