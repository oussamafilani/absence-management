
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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import Metier.*;
 

@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {
    
    
    RequestDispatcher rd;
    HttpSession session;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DAO dao = new DAO();
        session = request.getSession();
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        
        String path=request.getServletPath();
        System.out.print(path);
        
        
        try{
            
            dao.getConnection();
            if(request.getParameter("username")!=null){
                session.setAttribute("username",request.getParameter("username"));
            }
            if(path.equalsIgnoreCase("/login")){
                if(dao.authentification(user,password)){
                    String type = dao.getUserType(user,password);
                    System.out.println("Sle type est :" +type);
                    if(type.equals("admin")){
                        rd = request.getRequestDispatcher("admin.jsp");
                        rd.forward(request, response);
                    }
                    else if(type.equals("enseignant")){
                        rd = request.getRequestDispatcher("enseignant");
                        rd.forward(request, response);
                    }
                    else if(type.equals("etudiant")){
                        rd = request.getRequestDispatcher("etudiant");
                        rd.forward(request, response);
                    }
                }
                else{
                    rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            }
            else if(path.equalsIgnoreCase("/admin")){
                ArrayList<Admin> admins = dao.getAdmins();
                ArrayList<Enseignant> enseignansts = dao.getEnseignant();
                ArrayList<Etudiant> etudiants = dao.getEtudiant();
                ArrayList<Module> modules = dao.getModule();
                session.setAttribute("admins", admins);
                session.setAttribute("enseignants", enseignansts);
                session.setAttribute("etudiants", etudiants);
                session.setAttribute("modules", modules);
                rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            }
            else if(path.equalsIgnoreCase("/createEn")){
                if(!dao.check(request.getParameter("pseudo"), request.getParameter("password"))){
                    if(dao.creatUser(request.getParameter("pseudo"), request.getParameter("password"), "enseignant")){
                    int id = dao.getUserId(request.getParameter("pseudo"));
                    Enseignant e = new Enseignant(id,request.getParameter("pseudo"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("adresse"),
                    request.getParameter("ville"),request.getParameter("email"),request.getParameter("phone"));
                        if(dao.createEnseignant(e)){
                            request.setAttribute("msg","bien inserer");
                            rd = request.getRequestDispatcher("createEnseignant.jsp");
                            rd.forward(request, response);
                        }else{
                            request.setAttribute("msg","pas inserer");
                            rd = request.getRequestDispatcher("createEnseignant.jsp");
                            rd.forward(request, response);
                        }
                    }else{
                    request.setAttribute("msg","pas inserer");
                    rd = request.getRequestDispatcher("createEnseignant.jsp");
                    rd.forward(request, response);
                    }      
                }
                else{
                       request.setAttribute("msg","error");
                       rd = request.getRequestDispatcher("createAdmin.jsp");
                       rd.forward(request, response);
                } 
            }
            else if(path.equalsIgnoreCase("/creatEt")){ 
                if(!dao.check(request.getParameter("pseudo"), request.getParameter("password"))){
                    if(dao.creatUser(request.getParameter("pseudo"), request.getParameter("password"), "etudiant")){
                        int id = dao.getUserId(request.getParameter("pseudo"));
                        Etudiant e = new Etudiant(id,request.getParameter("cne"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("date_naiss"),
                        request.getParameter("ville_naiss"),request.getParameter("adrs"),request.getParameter("ville"),request.getParameter("email")
                        ,request.getParameter("phone"));
                        if(dao.creatEtudiant(e)){
                            request.setAttribute("msg","bien inserer");
                            rd = request.getRequestDispatcher("creatEtudiant.jsp");
                            rd.forward(request, response);
                        }else{
                            request.setAttribute("msg","bien inserer");
                            rd = request.getRequestDispatcher("creatEtudiant.jsp");
                            rd.forward(request, response);
                        }
                    }
                    else{
                        request.setAttribute("msg","pas inserer");
                        rd = request.getRequestDispatcher("creatEtudiant.jsp");
                        rd.forward(request, response);
                    }
                }
                else{
                       request.setAttribute("msg","error");
                       rd = request.getRequestDispatcher("creatEtudiant.jsp");
                       rd.forward(request, response);
                } 
            }
            else if(path.equalsIgnoreCase("/createA")){
                if(!dao.check(request.getParameter("pseudo"), request.getParameter("password"))){
                    if(dao.creatUser(request.getParameter("pseudo"), request.getParameter("password"), "admin")){
                       int id = dao.getUserId(request.getParameter("pseudo"));
                       Admin a = new Admin(id,request.getParameter("pseudo"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"));
                       if(dao.creatAdmin(a)){
                           request.setAttribute("msg","bien inserer");
                           rd = request.getRequestDispatcher("createAdmin.jsp");
                           rd.forward(request, response);
                       }else{
                           request.setAttribute("msg","bien inserer");
                           rd = request.getRequestDispatcher("createAdmin.jsp");
                           rd.forward(request, response);
                       }
                   }
                   else{
                       request.setAttribute("msg","bien inserer");
                       rd = request.getRequestDispatcher("createAdmin.jsp");
                       rd.forward(request, response);
                   }   
                }
                else{
                       request.setAttribute("msg","error");
                       rd = request.getRequestDispatcher("createAdmin.jsp");
                       rd.forward(request, response);
                } 
            }
            else if(path.equalsIgnoreCase("/createM")){
                if(request.getParameter("nom").equals("")){
                    request.setAttribute("msg","pas inserer");
                    rd = request.getRequestDispatcher("createModule.jsp");
                    rd.forward(request, response);
                }
                else{
                    Module m = new Module("",request.getParameter("nom"));
                    if(dao.creatModule(m)){
                        request.setAttribute("msg","bien inserer");
                        rd = request.getRequestDispatcher("createModule.jsp");
                        rd.forward(request, response);
                    }else{
                        request.setAttribute("msg","pas inserer");
                        rd = request.getRequestDispatcher("createModule.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
