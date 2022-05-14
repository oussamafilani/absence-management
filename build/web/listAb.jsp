

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
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
            <%if(request.getAttribute("absences")!=null){%>
            <% ArrayList<Absence> absence = (ArrayList<Absence>)request.getAttribute("absences"); %> 
                <div class="row">
                    <h2>Liste des absence :</h2>
                    <center>
                       
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>intitule_module</th>
                                <th>CNE</th>
                                <th>nom_etu</th>
                                <th>prenom_etu</th>
                                <th>justifiee</th>
                                <th>comm_abs</th>
                                <th>date_seance</th>
                                <th>heure_debut</th>
                                <th>heure_fin</th>
                                <th>type_seance</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(Absence a:absence){%>
                            <tr>
                                <td><%out.println(a.getIntitule_module());%></td>
                                <td><%out.println(a.getCNE());%></td>
                                <td><%out.println(a.getNom_etu());%></td>
                                <td><%out.println(a.getPrenom_etu());%></td>
                                <td><%out.println(a.getJustifiee());%></td>
                                <td><%out.println(a.getComm_abs());%></td>
                                <td><%out.println(a.getDate_seance());%></td>
                                <td><%out.println(a.getHeure_debut());%></td>
                                <td><%out.println(a.getHeure_fin());%></td>
                                <td><%out.println(a.getType_seance());%></td>
                            </tr>   
                            <%}%>
                        </tbody>
                    </table>
                    </center> 
                </div>       
            <%}else{%>
                <div class="row">
                <% ArrayList<Etudiant> etudiants = (ArrayList<Etudiant>)request.getAttribute("etudiants"); %>
                    <form method="post" action="listAb">
                        <input type="hidden" name="id" value="<%=session.getAttribute("id")%>"/>
                        <div class="form-group form-inline">
                            <label for="cne">CNE :</label>
                            <select name="cne" class="form-control">
                                <option value="" selected disabled>CNE</option>
                                <%for(Etudiant e:etudiants){%>
                                <option value="<%=e.getCne() %>">
                                    <%out.println(e.getCne()); %>
                                </option>
                                <%}%>
                            </select>
                            <input name="submit" type="submit" class="btn btn-primary" value="Afficher" />
                        </div>   
                    </form>
                </div>            
                <div class="row">
                    <h2>Liste des absence :</h2>
                    <center>
                    <% ArrayList<Absence> absence = (ArrayList<Absence>)request.getAttribute("absence"); %>    
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>intitule_module</th>
                                <th>CNE</th>
                                <th>nom_etu</th>
                                <th>prenom_etu</th>
                                <th>justifiee</th>
                                <th>comm_abs</th>
                                <th>date_seance</th>
                                <th>heure_debut</th>
                                <th>heure_fin</th>
                                <th>type_seance</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(Absence a:absence){%>
                            <tr>
                                <td><%out.println(a.getIntitule_module());%></td>
                                <td><%out.println(a.getCNE());%></td>
                                <td><%out.println(a.getNom_etu());%></td>
                                <td><%out.println(a.getPrenom_etu());%></td>
                                <td><%out.println(a.getJustifiee());%></td>
                                <td><%out.println(a.getComm_abs());%></td>
                                <td><%out.println(a.getDate_seance());%></td>
                                <td><%out.println(a.getHeure_debut());%></td>
                                <td><%out.println(a.getHeure_fin());%></td>
                                <td><%out.println(a.getType_seance());%></td>
                            </tr>   
                            <%}%>
                        </tbody>
                    </table>
                        Nombre Total des Absences:  <%out.println(absence.size());%><br><br>
                    <br><br>
                    </center>                
                </div>
            <%}%>    
        </div>
    </body>
</html>
