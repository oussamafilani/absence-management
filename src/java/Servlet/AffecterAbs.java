/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DAO;
import Metier.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author OUSSAMA
 */
@WebServlet(name = "AffecterAbs", urlPatterns = {"/AffecterAbs"})
public class AffecterAbs extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        try (PrintWriter out = response.getWriter()) {
            dao.getConnection();
            if(request.getParameter("idE")!=null){
                session.setAttribute("idE",request.getParameter("idE"));
                rd = request.getRequestDispatcher("affectAbs.jsp");
                rd.forward(request, response);
            }
            if(request.getParameter("submit")!=null){
                int idS = (int)session.getAttribute("idS");
                int idU = Integer.parseInt(request.getParameter("idU"));
                if(dao.createAbsence(idS, idU, request.getParameter("justifier"), request.getParameter("comm"))){
                    rd = request.getRequestDispatcher("gestAb");
                    rd.forward(request, response); 
                }else{
                    request.setAttribute("msg","pas absence");
                    rd = request.getRequestDispatcher("affectAbs.jsp");
                    rd.forward(request, response); 
                }
            }
        }
    }

    

}
