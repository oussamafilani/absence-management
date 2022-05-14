
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DAO;
import java.util.ArrayList;
import Metier.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "enseignant", urlPatterns = {"/enseignant"})
public class enseignant extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String path=request.getServletPath();
        System.out.println(path);
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            if(path.equalsIgnoreCase("/enseignant")){
                
                int id =dao.getUserId(request.getParameter("username"));
                session.setAttribute("id", id);
                ArrayList<Module> modules = dao.getVosModule(id);
                ArrayList<Seance> seances = dao.getVosSeance(id);
                session.setAttribute("modules", modules);
                session.setAttribute("seances", seances);  
                rd = request.getRequestDispatcher("enseignant.jsp");
                rd.forward(request, response);
            }
            else if(path.equalsIgnoreCase("/module")){
                
                int id =Integer.parseInt(request.getParameter("id"));
                System.out.println("Servlet.enseignant.service()"+id);
                ArrayList<Module> modules = dao.getVosModule(id);
                ArrayList<Seance> seances = dao.getVosSeance(id);
                session.setAttribute("modules", modules);
                session.setAttribute("seances", seances);  
                rd = request.getRequestDispatcher("enseignant.jsp");
                rd.forward(request, response);
            }
            else if(path.equalsIgnoreCase("/creatSeance")){
                if(request.getParameter("submit")==null){
                    int idu = Integer.parseInt(request.getParameter("id"));
                    ArrayList<Module> modules = dao.getVosModule(idu);
                    session.setAttribute("id", idu);
                    session.setAttribute("modules", modules);
                    rd = request.getRequestDispatcher("creatSeance.jsp");
                    rd.forward(request, response); 
                }
                else if(request.getParameter("submit")!=null) {
                    int idM = dao.getModulID(request.getParameter("module"));
                    int idU = Integer.parseInt(request.getParameter("idU1"));
                    Seance seance = new Seance(request.getParameter("module"),request.getParameter("date_sea"),request.getParameter("heure_deb"),request.getParameter("heure_fin"),
                            request.getParameter("type_sea"),0);
                    if(dao.creatSeance(seance, idM, idU)){
                        request.setAttribute("msg","bien insertion");
                        rd = request.getRequestDispatcher("creatSeance.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        request.setAttribute("msg","pas insertion");
                        rd = request.getRequestDispatcher("creatSeance.jsp");
                        rd.forward(request, response);
                    }
                }
            }
            else if(path.equalsIgnoreCase("/listAb")){
                if(request.getParameter("cne")!=null){
                    int id = (int)session.getAttribute("id");
                    ArrayList<Absence> abs = dao.getAbsEt(id,request.getParameter("cne"));
                    request.setAttribute("absences", abs);
                    rd = request.getRequestDispatcher("listAb.jsp");
                    rd.forward(request, response);
                }
                else if(request.getParameter("cne")==null){
                    int id = Integer.parseInt(request.getParameter("id"));
                    session.setAttribute("id",id);
                    ArrayList<Absence> abs = dao.getAbs(id);
                    ArrayList<Etudiant> etudiants = dao.getCneEtudiant(id);
                    request.setAttribute("absence", abs);
                    request.setAttribute("etudiants", etudiants);
                    rd = request.getRequestDispatcher("listAb.jsp");
                    rd.forward(request, response);
                }
            }
            else if(path.equalsIgnoreCase("/gestAb")){
                if(request.getParameter("id")!=null){
                    int id = Integer.parseInt(request.getParameter("id"));
                    session.setAttribute("id", id);
                    request.setAttribute("test","pas good");
                    rd = request.getRequestDispatcher("gestionAb.jsp");
                    rd.forward(request, response);
                }
                else if(request.getParameter("submit")!=null){
                    int idU = Integer.parseInt(request.getParameter("idU"));
                    System.out.println(idU);
                    ArrayList<Etudiant> etudiants = dao.getAbsEt(idU,request.getParameter("date_sea"),request.getParameter("heure_deb"),request.getParameter("heure_fin"));
                    ArrayList<Seance> seance = dao.getAbsSeance(idU,request.getParameter("date_sea"),request.getParameter("heure_deb"),request.getParameter("heure_fin"));
                    session.setAttribute("etudiants", etudiants);
                    session.setAttribute("seance", seance);
                    request.setAttribute("test","good");
                    
                    session.setAttribute("idS", dao.getSeanceId(request.getParameter("date_sea"),request.getParameter("heure_deb"),request.getParameter("heure_fin")));
                    System.out.println("Servlet.enseignant.service()");
                    rd = request.getRequestDispatcher("gestionAb.jsp");
                    rd.forward(request, response);
                }
                else{
                    rd = request.getRequestDispatcher("gestionAb.jsp");
                    rd.forward(request, response);
                }
            }
            
        }
    }

    

}
