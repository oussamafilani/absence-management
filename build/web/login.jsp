

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
     <meta charset="utf-8">
     <meta  content="width=device-width, initial-scale=1.0">
     <title>Login Form</title>
     <link rel="stylesheet" href="css/bootstrap.min.css">
     <script src="js/jquery.min.js"></script>
     <script src="js/bootstrap.min.js"></script>

</head>
<body>
     <div class="container">
     <!-- header -->
        <div class="row">
          <div class="col-lg-6 col-sm-6">
               <!-- Le titre [FIX] -->
               <h1>Gestion des absences</h1>
          </div>
        </div>
        <hr/>
        <div class="container col-md-4 col-md-offset-4 well ">
              <form method="post" action="login">
                <div class="form-group">
                  <label>Nom d'utilisateur</label>
                  <input name="username" class="form-control" required>
                </div>
                <div class="form-group">
                  <label>Mot de passe</label>
                  <input name="password" type="password" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">Connexion</button>
              </form><br/>
              <% if(request.getParameter("username")!=null){%>
                <div class="alert alert-danger" role="alert">
                    le mot de passe ou username est incorrect !
                </div>
              <%}%>
        </div>   
     </div> 

</body>
</html>