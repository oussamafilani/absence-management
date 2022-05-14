
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
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "modifierModule_1", urlPatterns = {"/modifierModule_1"})
public class modifierModule extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            session.setAttribute("id",request.getParameter("id"));
            
            if(request.getParameter("nom")!=null){
                dao.getConnection();
                int id = Integer.parseInt(request.getParameter("id"));
                if(dao.updateModule(id, request.getParameter("nom"))){
                    request.setAttribute("msg","bien update");
                    RequestDispatcher rd = request.getRequestDispatcher("modifierModule.jsp");
                    rd.forward(request, response);
                }
                else{
                    request.setAttribute("msg","pas update");
                    RequestDispatcher rd = request.getRequestDispatcher("modifierModule.jsp");
                    rd.forward(request, response); 
                }
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("modifierModule.jsp");
                rd.forward(request, response);
            }
        }
    }
}
