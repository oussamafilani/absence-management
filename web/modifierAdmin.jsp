

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAO" %>
<%@page import="Metier.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css"">
    </head>
    <body>
        <div class="container">
            <%@include file="include/header.jsp" %>
            <%@include file="include/navbar.jsp" %>    
         <div class="row">
             <%! DAO dao = new DAO();%><%dao.getConnection(); %>
             <%Admin a = dao.getAdminsById(Integer.parseInt(String.valueOf(session.getAttribute("id"))));%>
	    <div class="col-md-6 col-md-offset-3">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                <h4>Modification d'un compte admin</h4>
	            </div>
	            <div class="panel-body">
                    <form method="post" action="ModifierAdmin">
                        <div class="form-group">
	                    <label for="name">Pseudo *</label>
	                    <input class="form-control" name="pseudo" placeholder="Pseudo" type="text" value="<%= a.getLogin()%>" required/>
	                </div>
	                <div class="form-group">
	                    <label for="subject">Nouveau Password *</label>
	                    <input class="form-control" name="password" placeholder="Password" type="password" required/>
	                </div>
	                <div class="form-group">
	                    <label for="subject">Confirm Password *</label>
	                    <input class="form-control" name="cpassword" placeholder="Confirm Password" type="password" required/>
	                </div>
			<div class="form-group">
	                    <label for="name">Prenom</label>
                            <input class="form-control" name="prenom" placeholder="Prenom" type="text" value="<%= a.getPrenom_admin() %>" required/>
                            <input type="hidden" name="idA" value="<%= session.getAttribute("id")%>"/><!-- hna fin kayen id dyal admin li anbadlo -->
	                </div>
	                <div class="form-group">
	                    <label for="name">Nom</label>
	                    <input class="form-control" name="nom" placeholder="Nom" type="text" value="<%= a.getNom_admin() %>" required/>
	                </div>
	                <div class="form-group">
	                    <label for="email">Email *</label>
	                    <input class="form-control" name="email" placeholder="Email" type="text" value="<%= a.getEmail_admin() %>" required/>
	                </div>
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
                    <%}
                    else if(request.getAttribute("msg").equals("les mot de passe ne sont pas compatible")){%>
                        <div class="alert alert-danger" role="alert">
                                les mot de passe ne sont pas compatible!
                        </div>
                    <%}%>
                <%}%>
            </div>
        </div>                
        </div>
    </body>
</html>
