

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
            <% ArrayList<Module> modules = (ArrayList<Module>)session.getAttribute("modules"); %>
            <h2>Vos Modules</h2>
            <% for(Module m: modules){ %>
		<h3>
                    <ul>
                        <li><%out.println(m.getIntitule_module()); %></li>
                    </ul>
		</h3>
            <%}%>    
            <hr>
	    <h2>Liste des seances :</h2>
	    <br>
            
	    <center>
		<table class="table table-striped">
                <% ArrayList<Seance> seances = (ArrayList<Seance>)session.getAttribute("seances"); %>
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
                    <% for(Seance s: seances){ %>
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
		Nombre Total des Seance: <%out.println(seances.size());%>
		<br><br>
                
            </center>
	</div>
    </body>
</html>
