
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Metier.*;
import java.util.ArrayList;
import DAO.DAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "etudiantAffecterCour_1", urlPatterns = {"/etudiantAffecterCour_1"})
public class etudiantAffecterCour extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            RequestDispatcher rd ;
            if(request.getParameter("id")!=null){
                session.setAttribute("id", request.getParameter("id"));
                ArrayList<Module> modules = dao.getModule();
                session.setAttribute("modules", modules);
                rd = request.getRequestDispatcher("affectEtude.jsp");
                rd.forward(request, response);
            }
            else if(request.getParameter("cmdl")!=null){
                int idM = dao.getModulID(request.getParameter("cmdl"));
                int idEt = Integer.parseInt(request.getParameter("idEt"));
                if(dao.etudierModul(idEt, idM)){
                    request.setAttribute("msg","bien affectation");
                    rd = request.getRequestDispatcher("affectEtude.jsp");
                    rd.forward(request, response);
                }else{
                    request.setAttribute("msg","pas affectation");
                    rd = request.getRequestDispatcher("affectEtude.jsp");
                    rd.forward(request, response); 
                }
            }    
        }
    }

    

}
