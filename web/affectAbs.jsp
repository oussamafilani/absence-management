

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="row">
		<div class="col-md-4 col-md-offset-4">
                    <form method="post" action="AffecterAbs">
                        <input type="hidden" name="idU" value="<%= session.getAttribute("idE")%>"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4>Affectation d'absence</h4>
                            </div>
                            <div class="panel-body">
                                <label>Absence Justifié ?</label><br>
                                <input  type="radio" name="justifier"  value="oui" checked required><label style="margin-left: 5px">Oui</label><br>
                                <input  type="radio" name="justifier"  value="non" checked required><label style="margin-left: 5px">Non</label><br><br>
                                <div class="form-group">
                                    <label for="comm">Commentaire:</label>
                                    <textarea class="form-control" rows="5" name="comm" required></textarea>
                                </div>
                                <input type="submit" name="submit" class="btn btn-warning" value="Affecter" />
                            </div>
                        </div>
                    </form>    
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <%if(request.getAttribute("msg") !=null){%>
                        <%if(request.getAttribute("msg").equals("pas absence")){%>
                            <div class="alert alert-danger" role="alert">
                                absence échoue!
                            </div>
                        <%}%> 
                    <%}%>
                </div>
            </div>           
        </div>    
    </body>
</html>
