
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <style>
    .bg-4 { 
    background-color: #2f2f2f;
    color: #ffffff;
    padding-top: 5px;
    
    footer{
        width:  1000px;
    }
}

</style>
    </head>
    <body>
     <div class="container">
        <%@include file="include/header.jsp" %>
        <%@include file="include/navbar.jsp" %>  
        <h3><b>Quel type d'utilisateur voulez vous afficher ?</b></h3>
        <form method="post" action="admin">
        <table class="choix" width="100%">
            <tr>
                <td>    
                    <input  type="radio" name="type"  value="Admin" checked><label style="margin-left: 5px">Admin</label>
                </td>
                <td>
                    <input type="radio" name="type" value="Enseignant"><label style="margin-left: 5px">Enseignant</label>
                </td>
                <td>
                    <input type="radio" name="type"   value="Etudiant"><label style="margin-left: 5px">Etudiant</label>
                </td>
                <td>
                    <input  type="radio" name="type"  value="Module"><label style="margin-left: 5px">Module</label>
                </td>
                <td>
                    <input class="btn btn-primary" type="submit" value="Afficher">
                </td>
            </tr>
	</table>
        </form>
        <% if(request.getParameter("type")!=null){%>
            <%if(request.getParameter("type").equals("Admin")){%>
            <% ArrayList<Admin> admins = (ArrayList<Admin>)session.getAttribute("admins"); %>
                <h3>Liste des admins</h3>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Pseudo</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Email</th>
                            <th class="ico">Changer le role</th>
                            <th class="ico">Modifier/Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Admin a:admins){ %>
                            <tr>
                                <td><%out.println(a.getLogin());%></td>
                                <td><%out.println(a.getNom_admin()); %></td>
                                <td><% out.println(a.getPrenom_admin()); %></td>
                                <td><% out.println(a.getEmail_admin());%></td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="AdmineChangeRole?id=<%= a.getId() %> ">
                                            <span class="glyphicon glyphicon-random" aria-hidden="true"></span>
                                        </a>
                                    </span>         
                                </td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="ModifierAdmin?id=<%= a.getId() %> ">
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        </a>
                                    </span>        
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="SupprimerAdmin?id=<%= a.getId() %> ">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                    </span>         
                                </td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
            <%}%>
            <%if(request.getParameter("type").equals("Enseignant")){%>
            <% ArrayList<Enseignant> enseignants = (ArrayList<Enseignant>)session.getAttribute("enseignants"); %>
                <h3>Liste des Enseignants</h3>
                <table class="table table-striped" style="margin-bottom:30px;">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Adresse</th>
                            <th>Ville</th>
                            <th>Email</th>
                            <th>Telephone</th>
                            <th class="ico">Affecter à une cour</th>
                            <th class="ico">Changer le role</th>
                            <th class="ico">Modifier/Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Enseignant e:enseignants){ %>
                            <tr>
                                <td><%out.println(e.getNom_ens()); %></td>
                                <td><% out.println(e.getPrenom_ens()); %></td>
                                <td><% out.println(e.getAdresse_ens());%></td>
                                <td><% out.println(e.getVille_ens());%></td>
                                <td><% out.println(e.getEmail_ens());%></td>
                                <td><% out.println(e.getPhone_ens());%></td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="affecterCour?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
                                        </a>
                                    </span>        
                                </td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="changeEnseignantRole?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-random" aria-hidden="true"></span>
                                        </a> 
                                    </span>        
                                </td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="modifierEnseignant?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        </a>
                                    </span>    
                                    <span type="button" class="btn btn-default btn-sm">    
                                        <a href="supprimerEnseignant?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                    </span>    
                                </td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
            <%}%>
            <%if(request.getParameter("type").equals("Etudiant")){%>
            <% ArrayList<Etudiant> etudiants = (ArrayList<Etudiant>)session.getAttribute("etudiants"); %>
                <h3>Liste des Etudiants</h3>
                <table class="table table-striped" style="margin-bottom:30px;">
                    <thead>
                        <tr>
                            <th>Cne</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Date Naissance</th>
                            <th>Ville Naissance</th>
                            <th>Adresse</th>
                            <th>Ville</th>
                            <th>Email</th>
                            <th>Telephone</th>
                            <th class="ico">Affecter à une cour</th>
                            <th class="ico">Changer le role</th>
                            <th class="ico">Modifier/Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Etudiant e: etudiants){ %>
                            <tr>
                                <td><%out.println(e.getCne()); %></td>
                                <td><% out.println(e.getNom_etu()); %></td>
                                <td><% out.println(e.getPrenom_etu());%></td>
                                <td><% out.println(e.getDate_naiss_etu());%></td>
                                <td><% out.println(e.getVille_naiss_etu());%></td>
                                <td><% out.println(e.getAdresse_etu());%></td>
                                <td><% out.println(e.getVille_etu());%></td>
                                <td><% out.println(e.getEmail_etu());%></td>
                                <td><% out.println(e.getPhone_etu());%></td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="etudiantAffecterCour?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
                                        </a>
                                    </span>    
                                </td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="changeEtudiantRole?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-random" aria-hidden="true"></span>
                                        </a>
                                    </span>    
                                </td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="modifierEtudiant?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        </a>
                                    </span>        
                                    <span type="button" class="btn btn-default btn-sm">    
                                        <a href="supprimerEtudiant?id=<%= e.getId() %>">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                    </span>        
                                </td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
            <%}%>
            <%if(request.getParameter("type").equals("Module")){%>
            <% ArrayList<Module> modules = (ArrayList<Module>)session.getAttribute("modules"); %>
                <h3>Liste des Modules</h3>
                <table class="table table-striped" style="margin-bottom:30px;">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Module</th>
                            <th class="ico">Modifier/Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Module m: modules){ %>
                            <tr>
                                <td><%out.println(m.getId_module()); %></td>
                                <td><%out.println(m.getIntitule_module()); %></td>
                                <td class="ico">
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="modifierModule?id=<%= m.getId_module() %>">
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        </a>
                                    </span>
                                    <span type="button" class="btn btn-default btn-sm">
                                        <a href="supprimerModule?id=<%= m.getId_module() %>">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                    </span>    
                                </td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
            <%}%>
        <%}%>    
     </div>
    
     
    </body>
</html>
