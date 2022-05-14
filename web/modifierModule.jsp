

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
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4>Modification du nom du module</h4>
                        </div>
                        <div class="panel-body">
                            <form method="post" action="modifierModule">
                            <div class="form-group">
                                <label for="name">Nom du Module *</label>
                                <input class="form-control" name="nom" placeholder="Nom du Module" type="text"  required/> 
                            </div>
                            <input name="id" type="hidden" value="<%= session.getAttribute("id") %>">   
                            <div class="form-group">
                                <input name="submit" type="submit" class="btn btn-primary" value="Update" />
                                <input name="cancel" type="reset" class="btn btn-default" value="Cancel" />
                            </div>
                            </form>    
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <%if(request.getAttribute("msg") !=null){%>
                        <%if(request.getAttribute("msg").equals("bien update")){%>
                            <div class="alert alert-success" role="alert">
                                bien update!
                            </div>
                        <%}
                        else if(request.getAttribute("msg").equals("pas update")){%>
                            <div class="alert alert-danger" role="alert">
                               update échoue!
                            </div>
                        <%}%> 
                    <%}%>
                </div>
            </div>
        </div>    
    </body>
</html>
