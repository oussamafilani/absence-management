

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
                <%@include file="include/navbar.jsp" %>
            <div class="row">
                <div class="col-md-2 col-md-offset-5">
                        <h3><b>Choix du Role</b></h3>
                    <div class="panel panel-default">
                        <form method="post" action="AdmineChangeRole">  
                            <div class="panel-heading">
                                <h4>Changer le role</h4>
                            </div>
                            <div class="panel-body"> 
                                <input type="hidden" name="idA" value="<%=session.getAttribute("idAdmin")%>">
                                <input type="radio" name="type" value="Enseignant" required><label style="margin-left: 5px">Enseignant</label><br><br>
                                <input type="radio" name="type"   value="Etudiant" required><label style="margin-left: 5px">Etudiant</label><br><br>
                                <input type="submit" class="btn btn-danger" value="Changer">
                            </div>  
                        </form>      
                    </div>
                </div>                
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <%if(request.getAttribute("msg") !=null){%>
                        <%if(request.getAttribute("msg").equals("bien changement")){%>
                            <div class="alert alert-success" role="alert">
                                bien changement!
                            </div>
                        <%}
                        else if(request.getAttribute("msg").equals("pas changement")){%>
                            <div class="alert alert-danger" role="alert">
                               changement échoue!
                            </div>
                        <%}%> 
                    <%}%>
                </div>
            </div>                    
        </div>    
    </body>
</html>
