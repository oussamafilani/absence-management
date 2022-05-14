

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
            <form method="post" action="createM"> 
	    <div class="col-md-6 col-md-offset-3">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                <h4>Creation d'un Module</h4>
	            </div>
	            <div class="panel-body">
	                <div class="form-group">
	                    <label for="name">Nom du Module *</label>
	                    <input class="form-control" name="nom" placeholder="Nom du Module" type="text" value="" required/>
	                </div>
	                <div class="form-group">
	                    <input name="submit" type="submit" class="btn btn-primary" value="Inserer" />
	                    <input name="cancel" type="reset" class="btn btn-default" value="Cancel" />
	                </div>
	            </div>
	        </div>
	    </div>
            </form>  
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <%if(request.getAttribute("msg") !=null){%>
                        <%if(request.getAttribute("msg").equals("bien inserer")){%>
                            <div class="alert alert-success" role="alert">
                                bien insertion!
                            </div>
                        <%}
                        else if(request.getAttribute("msg").equals("pas inserer")){%>
                            <div class="alert alert-danger" role="alert">
                               insertion échoue!
                            </div>
                        <%}%> 
                    <%}%>
                </div>
            </div>
        </div>
    </body>
</html>
