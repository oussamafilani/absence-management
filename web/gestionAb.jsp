

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <%@include file="include/header.jsp" %>
            <%@include file="include/navbar_ens.jsp" %>
                <form method="post" action="gestAb">
                    <input type="hidden" name="idU" value="<%=session.getAttribute("id")%>"/>
                    <table class="choix">
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="date_sea">Date seance</label>
                                    <input name="date_sea" class="form-control" type="text" placeholder="yyyy-mm-dd" required>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <label for="heure_deb">Heure debut</label>
                                    <input name="heure_deb" class="form-control" type="text" placeholder="hr-mn-ss" required>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <label for="heure_fin">Heure fin</label>
                                    <input name="heure_fin" class="form-control" type="text" placeholder="hr-mn-ss" required>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <input name="submit" type="submit" class="btn btn-primary" value="Afficher" />
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
                   
        <% if(request.getAttribute("test").equals("good")){%>
               
                
                <% ArrayList<Etudiant> etudiants = (ArrayList<Etudiant>)session.getAttribute("etudiants"); %>
                <% ArrayList<Seance> seance = (ArrayList<Seance>)session.getAttribute("seance"); %>
                <%! DAO dao = new DAO();%>
                <%dao.getConnection(); %>
                <% int idS = dao.getSeanceId(request.getParameter("date_sea"),request.getParameter("heure_deb"),request.getParameter("heure_fin")) ;%>
                <h2>Info sur la Seance :</h2>
		<table class="table table-striped">
		    <thead>
		    	<tr>
                            <th>Module</th>
                            <th>Date seance</th>
                            <th>Heure debut</th>
                            <th>Heure fin</th>
                            <th>Type seance</th>
		      	</tr>
		    </thead>
		    <tbody>
                        <%for(Seance s:seance){%>
                            <tr>
                                <td><%out.println(s.getIntitule_module());%></td>
                                <td><%out.println(s.getDate());%></td>
                                <td><%out.println(s.getHeur_debut());%></td>
                                <td><%out.println(s.getHeur_fin());%></td>
                                <td><%out.println(s.getType_seance());%></td>
                            </tr>
                        <%}%>
                    </tbody>
	  	</table>
                
                <h2>Liste des etudiants :</h2>
		<center>
                <table class="table table-striped">
                    <thead>
		    	<tr>
                            <th>CNE</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Affecter une absence</th>
                            <th>Absence déja affecter</th>
		      	</tr>
		    </thead>
		    <tbody>
                        
                        <%for(Etudiant e:etudiants){%>
                            <tr>
                                <td><%out.println(e.getCne());%></td>
                                <td><%out.println(e.getNom_etu());%></td>
                                <td><%out.println(e.getPrenom_etu());%></td>
                                <td>
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="AffecterAbs?idE=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-flash" aria-hidden="true"></span>
                                        </a>
                                    </span>
                                </td>
                                <td>
                                    <%if(dao.checkAbsence(idS,e.getId())){
                                       out.print("OUI");
                                    }else{
                                       out.print("NON"); 
                                    }%>
                                </td>
                            </tr>
                        <%}%>
                    </tbody>    
                </table>
            </div>	
        <%}%>
    </body>
</html>
