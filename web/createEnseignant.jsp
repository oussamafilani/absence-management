

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
            <form method="post" action="createEn">   
	    <div class="col-md-6 col-md-offset-3">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                <h4>Creation d'un compte enseignant</h4>
	            </div>
	            <div class="panel-body">
	                <div class="form-group">
	                    <label for="name">Pseudo *</label>
	                    <input class="form-control" name="pseudo" placeholder="Pseudo" type="text" value="" required/>
	                </div>
	                <div class="form-group">
	                    <label for="subject">Password *</label>
	                    <input class="form-control" name="password" placeholder="Password" type="password" required/>
	                </div>
	                <div class="form-group">
	                    <label for="subject">Confirm Password *</label>
	                    <input class="form-control" name="cpassword" placeholder="Confirm Password" type="password" required/>
	                </div>
			<div class="form-group">
	                    <label for="name">Prénom</label>
	                    <input class="form-control" name="prenom" placeholder="Prenom" type="text" value="" required/>
	                </div>
	                <div class="form-group">
	                    <label for="name">Nom</label>
	                    <input class="form-control" name="nom" placeholder="Nom" type="text" value="" required/>
	                </div>
	                <div class="form-group">
	                    <label for="name">Adresse</label>
	                    <input class="form-control" name="adresse" placeholder="Adresse" type="text" value="" required/>
	                </div>

	                <div class="form-group">
	                    <label for="name">Ville</label>
	                    <input class="form-control" name="ville" placeholder="Ville" type="text" value="" required/>
	                </div>
	                <div class="form-group">
	                    <label for="email">Email *</label>
	                    <input class="form-control" name="email" placeholder="Email" type="text" value="" required />
	                </div>
	                <div class="form-group">
	                    <label for="name">Téléphone</label>
	                    <input class="form-control" name="phone" placeholder="Telephone" type="text" value="" required/>
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
                        <%}else if(request.getAttribute("msg").equals("error")){%>
                            <div class="alert alert-danger" role="alert">
                               le compte est déjà existé!
                            </div>
                        <%}%> 
                    <%}%>
                </div>
         </div>
    </div>    
    </body>
</html>
