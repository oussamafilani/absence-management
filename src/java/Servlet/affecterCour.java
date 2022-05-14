
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
import javax.servlet.http.HttpSession;
import Metier.*;
import java.util.ArrayList;
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "affecterCour", urlPatterns = {"/affecterCour"})
public class affecterCour extends HttpServlet {


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
                rd = request.getRequestDispatcher("affecterCour.jsp");
                rd.forward(request, response);
            }
            else if(request.getParameter("cmdl")!=null){
                int idM = dao.getModulID(request.getParameter("cmdl"));
                int idE = Integer.parseInt(request.getParameter("idE"));
                if(dao.affectCour(idE, idM)){
                    request.setAttribute("msg","bien affectation");
                    rd = request.getRequestDispatcher("affecterCour.jsp");
                    rd.forward(request, response);
                }else{
                    request.setAttribute("msg","pas affectation");
                    rd = request.getRequestDispatcher("affecterCour.jsp");
                    rd.forward(request, response); 
                }
            }
        }
    }

  

}
