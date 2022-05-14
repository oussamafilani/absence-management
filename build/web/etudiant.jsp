

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etudiant</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <%@include file="include/header.jsp" %>
            <hr>
            <center>
                <% Etudiant etudiant = (Etudiant)session.getAttribute("etd"); %>
                <% ArrayList<Absence> absences = (ArrayList<Absence>)session.getAttribute("abs"); %>
                <!-- ADD here les infos de l'etudiant ;) please  DONE-->
                <h3>L'étudiant <b><%out.println(etudiant.getNom_etu());%><%out.println(" "+etudiant.getPrenom_etu());%> </b></h3>
                <div class="col-md-6 col-md-offset-3 well">
                    <p>CNE : <b><%out.println(etudiant.getCne());%></b></p>
                    <p>Nom : <b><%out.println(etudiant.getNom_etu());%></b></p>
                    <p>Prenom : <b><%out.println(etudiant.getPrenom_etu());%></b></p>
                    <p>Date de naissance : <b><%out.println(etudiant.getDate_naiss_etu());%></b></p>
                    <p>Ville de naissance : <b><%out.println(etudiant.getVille_naiss_etu());%></b></p>
                    <p>Adresse : <b><%out.println(etudiant.getAdresse_etu());%></b></p>
                    <p>Ville : <b><%out.println(etudiant.getVille_etu());%></b></p>
                    <p>Email : <b><%out.println(etudiant.getEmail_etu());%></b></p>
                    <p>Telephone : <b><%out.println(etudiant.getPhone_etu());%></b></p>
                </div>

                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

                <!-- Si il n'y a pas d'absence id_absence va etre vide ;) donc je l'exploit-->
                <%if(absences!=null){%>
                <h3>Table d'absence de l'étudiant <b><%out.println(etudiant.getNom_etu());%></b></h3>
                <br>           
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Module</th>
                            <th>Date seance</th>
                            <th>Heure debut</th>
                            <th>Heure fin</th>
                            <th>Type seance</th>
                            <th>Justifiee</th>
                            <th>Commentaire</th>
                        </tr>
                    </thead>
                    <tbody>
                         <%for(Absence a:absences){%>
                            <tr>
                                <td><%out.println(a.getIntitule_module());%></td>
                                <td><%out.println(a.getDate_seance());%></td>
                                <td><%out.println(a.getHeure_debut());%></td>
                                <td><%out.println(a.getHeure_fin());%></td>
                                <td><%out.println(a.getType_seance());%></td>
                                <td><%out.println(a.getJustifiee());%></td>
                                <td><%out.println(a.getComm_abs());%></td>
                            </tr>   
                            <%}%>
                    </tbody>
                </table>
                Nombre Total d'absences: <%out.println(absences.size());%><br>
                <%}else{%>
                Nombre Total d'absences: 0 <br>
                <%}%>
            </center>
	</div>
    </body>
</html>
