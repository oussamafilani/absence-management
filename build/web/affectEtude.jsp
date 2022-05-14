

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
            <%@include file="include/navbar.jsp" %> 
            <div class="row">
		    <div class="col-md-4 col-md-offset-4">
		        <h3><b>Choix du Module</b></h3>
		        <div class="panel panel-default">
		            <div class="panel-heading">
		                <h4>Choix du Module</h4>
		            </div>
                            <form method="post" action="etudiantAffecterCour">
		            <div class="panel-body">
                                <input name="idEt" type="hidden" value="<%= session.getAttribute("id") %>">
                                <div class="form-group">
                                    <label for="cmdl">Nom du Module </label>
                                    <select name="cmdl" class="form-control">
                                        <% ArrayList<Module> modules = (ArrayList<Module>)session.getAttribute("modules"); %>
                                        <% for(Module m: modules){ %>
                                            <option value="<%=m.getIntitule_module() %>">
                                                <%out.println(m.getIntitule_module()); %>
                                            </option>
                                        <%}%>
                                    </select>
                                      
                                </div>
                                <center>
                                    <div class="form-group">
                                        <input name="submit" type="submit" class="btn btn-primary" value="Affecter" />
                                    </div>
                                </center>          
                            </div>
                            </form>           
                        </div>
                    </div>
	    </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <%if(request.getAttribute("msg") !=null){%>
                        <%if(request.getAttribute("msg").equals("bien affectation")){%>
                            <div class="alert alert-success" role="alert">
                                bien affectation!
                            </div>
                        <%}
                        else if(request.getAttribute("msg").equals("pas affectation")){%>
                            <div class="alert alert-danger" role="alert">
                               affectation échoue!
                            </div>
                        <%}%> 
                    <%}%>
                </div>
            </div>                           
        </div>
    </body>
</html>
