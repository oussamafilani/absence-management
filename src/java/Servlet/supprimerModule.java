
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
@WebServlet(name = "supprimerModule_1", urlPatterns = {"/supprimerModule_1"})
public class supprimerModule extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            int id = Integer.parseInt(request.getParameter("id"));
            if(dao.deletAffectModul(id) ){
                if(dao.deletEtudierModul(id) ){
                    if(dao.deletteModule(id)){
                    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);   
                    }  
                }
                else if(dao.deletteModule(id)){
                    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);   
                } 
            }
            else if(dao.deletEtudierModul(id)){
                if(dao.deletAffectModul(id) ){
                    if(dao.deletteModule(id)){
                        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                        rd.forward(request, response);   
                    }  
                }
                else if(dao.deletteModule(id)){
                    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);   
                } 
            }
            else{
               if(dao.deletteModule(id)){
                    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);   
                }  
            }
        }
    }

    

}
